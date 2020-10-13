package com.jinx.register.remote;


import com.alibaba.fastjson.JSONObject;
import com.jinx.common.URL;
import com.jinx.register.support.FailbackRegister;

import java.io.*;
import java.util.*;

/**
 * RemoteRegister简介
 * 通过文件的形式模拟远程服务
 *
 * @author wangxin119
 * @date 2020-08-29 23:37
 */
public class LocaleRegister extends FailbackRegister {
    //key 为接口名，value为 URL
    private static Map<String, List<URL>> REGISTER = new HashMap<>();

    public static List<URL> get(String interfaceName) {
        return getFile().get(interfaceName);
    }

    public static URL getRandom(String interfaceName) {
        List<URL> urls = LocaleRegister.get(interfaceName);
        System.out.println("[wangxin] urls:" + JSONObject.toJSONString(urls));
        int i = new Random().nextInt(urls.size());
        return urls.get(i);
    }

    /**
     * 保存到注册中心中 及 registryCenter.txt 中
     */
    private static void saveFile() {
        try {
            FileOutputStream fos = new FileOutputStream("registryCenter.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(REGISTER);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doRegister(URL url) {
        List<URL> urls;
        //获取已有的注册信息
        //例子：{"provider.impl.HelloServiceImpl":[{"hostname":"127.0.0.1","port":8080,"protocal":"http","weight":3},{"hostname":"127.0.0.1","port":8081,"protocal":"http","weight":3}],"api.HelloService":[{"hostname":"127.0.0.1","port":8080,"protocal":"http","weight":3},{"hostname":"127.0.0.1","port":8081,"protocal":"http","weight":3}]}
        Map<String, List<URL>> fileMap = getFile();
        if (null != fileMap && fileMap.size() > 0) {
            REGISTER = fileMap;
        }

        String interfaceName = url.getPath();
        if (null != fileMap && fileMap.containsKey(interfaceName) && fileMap.get(interfaceName).size() > 0) {
            //此接口已经注册
            urls = fileMap.get(interfaceName);
            List<URL> list = new ArrayList<>();
            boolean addNewUrl = true;
            for (URL urlTmp : urls) {
                list.add(urlTmp);
                if (compareUrl(urlTmp, url)) {//去重
                    addNewUrl = false;
                }
            }
            if (addNewUrl) {
                list.add(url);
            }
            REGISTER.put(interfaceName, list);
        } else {
            //此接口未注册
            urls = Collections.singletonList(url);
            REGISTER.put(interfaceName, urls);
        }
        saveFile();
    }

    /**
     * 获取注册中心的列表
     *
     * @return
     */
    private static Map<String, List<URL>> getFile() {
        try {
            FileInputStream fis = new FileInputStream("registryCenter.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Map<String, List<URL>> map = (Map<String, List<URL>>) ois.readObject();
            ois.close();
            fis.close();
            return map;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("文件内容为空");
        }
        return null;
    }

    /**
     * 比较两个URL是否相同
     *
     * @param url1
     * @param url2
     * @return
     */
    public static boolean compareUrl(URL url1, URL url2) {
        if (url1 == null || url2 == null) {
            return false;
        }
        if (url1.getHostname().equals(url2.getHostname()) && url1.getPort() == url2.getPort() && url1.getProtocal().equals(url2.getProtocal())) {
            return true;
        } else {
            return false;
        }
    }

    //TODO 后续研究
    @Override
    public boolean isAvailable() {
        return true;
    }
}

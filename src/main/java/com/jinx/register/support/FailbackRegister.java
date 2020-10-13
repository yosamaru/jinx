package com.jinx.register.support;

import com.jinx.common.URL;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 本地注册，失败立即返回
 */
public abstract class FailbackRegister extends AbstractRegistry {

    //key 为接口名，value为 URL
    private static Map<String, List<URL>> REGISTER = new HashMap<>();
    private URL registryUrl;

    @Override
    public void register(URL url) {
        if (!acceptable(url)){
            
        }
        super.register(url);
        try {
            doRegister(url);
        } catch (Exception e) {
            // 失败添加监听，通过时间轮，就行重试
        }
    }

    protected abstract void doRegister(URL url);

    /**
     * url格式参数检查
     * @param urlToRegistry
     * @return
     */
    protected boolean acceptable(URL urlToRegistry) {
        return true;
    }
}

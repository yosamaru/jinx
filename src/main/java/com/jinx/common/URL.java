package com.jinx.common;

import java.io.Serializable;
import java.util.Map;


/**
 * protocol://username:password@host:port/path?key=value&key=value
 */
public class URL implements Serializable{
    // 主机
    private String hostname;
    // 端口
    private Integer port;
    // 默认权重
    private Integer weight;
    // 一般是 dubbo 中的各种协议 如：dubbo thrift http zk
    private String protocal;
    // 接口名称
    private String path;
    // 参数键值对
    private Map<String, String> parameters;

    private Map<String, Map<String, String>> methodParameters;

    public URL(String hostname, Integer port, Integer weight, String protocal, String path, Map<String, String> parameters, Map<String, Map<String, String>> methodParameters) {
        this.hostname = hostname;
        this.port = port;
        this.weight = weight;
        this.protocal = protocal;
        this.path = path;
        this.parameters = parameters;
        this.methodParameters = methodParameters;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getProtocal() {
        return protocal;
    }

    public void setProtocal(String protocal) {
        this.protocal = protocal;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    public Map<String, Map<String, String>> getMethodParameters() {
        return methodParameters;
    }

    public void setMethodParameters(Map<String, Map<String, String>> methodParameters) {
        this.methodParameters = methodParameters;
    }
}

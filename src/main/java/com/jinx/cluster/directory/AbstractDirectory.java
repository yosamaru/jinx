package com.jinx.cluster.directory;


import com.jinx.cluster.Directory;
import com.jinx.common.URL;
import com.jinx.rpc.Invocation;
import com.jinx.rpc.Invoker;
import com.jinx.rpc.RpcException;

import java.util.List;

public abstract class AbstractDirectory<T> implements Directory<T> {

    private final URL url;

    private volatile boolean destroyed = false;

    private volatile URL consumerUrl;

    public AbstractDirectory(URL url) {
        // 初始化url
        this.url = url;
    }


    @Override
    public List<Invoker<T>> list(Invocation invocation) throws RpcException {
        if (destroyed) {
            throw new RpcException("Directory already destroyed .url: " + getUrl());
        }

        return doList(invocation);
    }

    @Override
    public URL getUrl() {
        return url;
    }

    public URL getConsumerUrl() {
        return consumerUrl;
    }

    public void setConsumerUrl(URL consumerUrl) {
        this.consumerUrl = consumerUrl;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    @Override
    public void destroy() {
        destroyed = true;
    }

    protected abstract List<Invoker<T>> doList(Invocation invocation) throws RpcException;

}

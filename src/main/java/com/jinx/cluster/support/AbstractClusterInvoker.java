package com.jinx.cluster.support;

import com.jinx.cluster.ClusterInvoker;
import com.jinx.cluster.Directory;
import com.jinx.cluster.LoadBalance;
import com.jinx.common.URL;
import com.jinx.rpc.Invocation;
import com.jinx.rpc.Invoker;
import com.jinx.rpc.Result;
import com.jinx.rpc.RpcException;

import java.util.List;

public abstract class AbstractClusterInvoker<T> implements ClusterInvoker<T> {
    protected Directory<T> directory;

    public AbstractClusterInvoker(Directory<T> directory) {
        this(directory, directory.getUrl());
    }

    public AbstractClusterInvoker(Directory<T> directory, URL url) {
        if (directory == null) {
            throw new IllegalArgumentException("service directory == null");
        }
        this.directory = directory;
    }

    @Override
    public URL getRegistryUrl() {
        return null;
    }

    @Override
    public Directory getDirectory() {
        return null;
    }

    @Override
    public Class getInterface() {
        return directory.getInterface();
    }

    @Override
    public Result invoke(Invocation invocation) throws RpcException {
        return doInvoke(invocation, null, null);
    }

    protected abstract Result doInvoke(Invocation invocation, List<Invoker<T>> invokers,
                                       LoadBalance loadbalance) throws RpcException;
    @Override
    public URL getUrl() {
        return null;
    }

    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    public void destroy() {

    }
}

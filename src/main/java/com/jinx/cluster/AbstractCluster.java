package com.jinx.cluster;

import com.jinx.rpc.Invoker;
import com.jinx.rpc.RpcException;

public abstract class AbstractCluster implements Cluster {

    @Override
    public<T> Invoker<T>  join(Directory<T> directory, String clusterName) throws RpcException {
        return buildClusterInterceptors(doJoin(directory), clusterName);
    }

    protected abstract <T> Invoker<T> doJoin(Directory<T> directory);

    /**
     * 根据传入的参数构建Cluster拦截器
     * @param clusterInvoker
     * @param key
     * @param <T>
     * @return
     */
    private <T> Invoker<T> buildClusterInterceptors(Invoker<T> clusterInvoker, String key) {
    	//TODO 后续研究
       return clusterInvoker;
    }
}

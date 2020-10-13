package com.jinx.cluster.support;

import com.jinx.cluster.Cluster;
import com.jinx.cluster.Directory;
import com.jinx.rpc.Invoker;
import com.jinx.rpc.RpcException;

public abstract class AbstractCluster implements Cluster {

    @Override
    public<T> Invoker<T>  join(Directory<T> directory, String clusterName) throws RpcException {
        return buildClusterInterceptors(doJoin(directory), clusterName);
    }

    protected abstract <T> Invoker<T> doJoin(Directory<T> directory);

    /**
     * 根据传入的参数构建ClusterInvoker
     * @param clusterInvoker
     * @param key
     * @param <T>
     * @return
     */
    private <T> Invoker<T> buildClusterInterceptors(Invoker<T> clusterInvoker, String key) {
       return clusterInvoker;
    }
}

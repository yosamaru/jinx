package com.jinx.cluster;

import com.jinx.rpc.Invoker;
import com.jinx.rpc.RpcException;

/**
 * 集群
 */
public interface Cluster {
    <T> Invoker<T> join(Directory<T> directory, String clusterName) throws RpcException;
}
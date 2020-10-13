package com.jinx.cluster;

import com.jinx.rpc.Invoker;
import com.jinx.rpc.RpcException;

/**
 *
 */
public interface Cluster {
    <T> Invoker<T> join(Directory directory, String clusterName) throws RpcException;
}
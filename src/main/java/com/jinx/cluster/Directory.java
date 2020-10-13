package com.jinx.cluster;


import com.jinx.common.Node;
import com.jinx.common.URL;
import com.jinx.rpc.Invocation;
import com.jinx.rpc.Invoker;
import com.jinx.rpc.RpcException;

import java.util.List;

public interface Directory<T> extends Node {

    /**
     * get service type.
     *
     * @return service type.
     */
    Class<T> getInterface();

    /**
     * list invokers.
     *
     * @return invokers
     */
    List<Invoker<T>> list(Invocation invocation) throws RpcException;

    List<Invoker<T>> getAllInvokers();

    URL getConsumerUrl();
}
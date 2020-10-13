package com.jinx.rpc;


import com.jinx.cluster.Directory;
import com.jinx.common.Node;
import com.jinx.common.URL;
import com.jinx.remoting.transport.Transport;
import com.jinx.cluster.LoadBalance;

import java.util.List;
public interface Invoker<T> extends Node {

    /**
     * get service interface.
     *
     * @return service interface.
     */
    Class<T> getInterface();

    /**
     * invoke.
     *
     * @param invocation
     * @return result
     * @throws RpcException
     */
    Result invoke(Invocation invocation) throws RpcException;

}
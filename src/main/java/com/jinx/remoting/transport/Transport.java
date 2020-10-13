package com.jinx.remoting.transport;


import com.jinx.rpc.Invocation;

public interface Transport {

    void start(String hostname, Integer port);

    /**
     *
     * @param invocation
     * @return
     */
    String send(Invocation invocation);


}

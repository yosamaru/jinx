package com.jinx.cluster;

import com.jinx.rpc.Invoker;

import java.util.List;

public class Directory {
    private volatile List<Invoker<?>> invokers;

    public Directory(List<Invoker<?>> invokers) {
        this.invokers = invokers;
    }

    public List<Invoker<?>> getInvokers() {
        return invokers;
    }

    public void setInvokers(List<Invoker<?>> invokers) {
        this.invokers = invokers;
    }
}

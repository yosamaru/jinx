package com.jinx.cluster.support;

import com.jinx.cluster.Directory;
import com.jinx.rpc.Invoker;

public class FailoverCluster extends AbstractCluster{
    @Override
    protected <T> Invoker<T> doJoin(Directory<T> directory) {
        return null;
    }
}

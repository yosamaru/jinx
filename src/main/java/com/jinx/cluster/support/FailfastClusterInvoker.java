package com.jinx.cluster.support;

import com.jinx.cluster.Directory;
import com.jinx.cluster.LoadBalance;
import com.jinx.rpc.Invocation;
import com.jinx.rpc.Invoker;
import com.jinx.rpc.Result;
import com.jinx.rpc.RpcException;

import java.util.List;

public class FailfastClusterInvoker<T> extends AbstractClusterInvoker<T> {

    public FailfastClusterInvoker(Directory<T> directory) {
        super(directory);
    }

    @Override
    protected Result doInvoke(Invocation invocation, List<Invoker<T>> invokers, LoadBalance loadbalance) throws RpcException {
        //通过负载均衡选择一个服务提供者
	    Invoker<T> invoker = select(loadbalance, invocation, invokers, null);
        try {
            return invoker.invoke(invocation);//执行远程调用
        } catch (Throwable e) {
            throw new RpcException("快速失败", e);//出错则抛出异常
        }
    }
}
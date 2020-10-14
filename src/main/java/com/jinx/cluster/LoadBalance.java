package com.jinx.cluster;

import java.util.List;

import com.jinx.common.URL;
import com.jinx.rpc.Invocation;
import com.jinx.rpc.Invoker;
import com.jinx.rpc.RpcException;

/**
 * LoadBalance简介
 * 负载均衡接口
 */
public interface LoadBalance {

	<T> Invoker<T> select(List<Invoker<T>> invokers, URL url, Invocation invocation) throws RpcException;
}
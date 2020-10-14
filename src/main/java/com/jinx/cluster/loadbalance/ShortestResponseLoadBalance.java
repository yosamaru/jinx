package com.jinx.cluster.loadbalance;

import java.util.List;

import com.jinx.common.URL;
import com.jinx.rpc.Invocation;
import com.jinx.rpc.Invoker;

public class ShortestResponseLoadBalance extends AbstractLoadBalance {
	@Override
	protected <T> Invoker<T> doSelect(List<Invoker<T>> invokers, URL url, Invocation invocation) {
		return null;
	}
}

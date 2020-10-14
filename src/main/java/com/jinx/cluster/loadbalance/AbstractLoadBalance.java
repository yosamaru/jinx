package com.jinx.cluster.loadbalance;

import java.util.List;

import org.springframework.util.CollectionUtils;

import com.jinx.cluster.LoadBalance;
import com.jinx.common.URL;
import com.jinx.rpc.Invocation;
import com.jinx.rpc.Invoker;

/**
 * 路由选择
 */
public abstract class AbstractLoadBalance implements LoadBalance {
	@Override
	public <T> Invoker<T> select(List<Invoker<T>> invokers, URL url, Invocation invocation) {
		if (CollectionUtils.isEmpty(invokers)) {
			return null;
		}
		if (invokers.size() == 1) {
			return invokers.get(0);
		}
		return doSelect(invokers, url, invocation);
	}

	protected abstract <T> Invoker<T> doSelect(List<Invoker<T>> invokers, URL url, Invocation invocation);
}

package com.jinx.cluster.support;

import java.util.List;

import com.jinx.cluster.Directory;
import com.jinx.cluster.LoadBalance;
import com.jinx.rpc.AppResponse;
import com.jinx.rpc.Invocation;
import com.jinx.rpc.Invoker;
import com.jinx.rpc.Result;
import com.jinx.rpc.RpcException;

public class FailbackClusterInvoker<T> extends AbstractClusterInvoker<T> {
	public FailbackClusterInvoker(Directory<T> directory) {
		super(directory);
	}

	@Override
	protected Result doInvoke(Invocation invocation, List<Invoker<T>> invokers, LoadBalance loadbalance) throws RpcException {
		Invoker<T> invoker = null;
		try {
			invoker = select(loadbalance, invocation, invokers, null);
			return invoker.invoke(invocation);
		} catch (Throwable e) {
			addFailed(loadbalance, invocation, invokers, invoker);
			return new AppResponse();
		}
	}

	/**
	 * 添加失败信息到时间轮定时器进行重试
	 * @param loadbalance
	 * @param invocation
	 * @param invokers
	 * @param lastInvoker
	 */
	private void addFailed(LoadBalance loadbalance, Invocation invocation, List<Invoker<T>> invokers, Invoker<T> lastInvoker) {
		//TODO 完成时间轮定时器重试代码
	}
}

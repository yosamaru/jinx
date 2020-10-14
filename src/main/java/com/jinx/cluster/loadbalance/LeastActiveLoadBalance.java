package com.jinx.cluster.loadbalance;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.jinx.common.URL;
import com.jinx.rpc.Invocation;
import com.jinx.rpc.Invoker;
import com.jinx.rpc.RpcStatus;

/**
 * 最小活跃数负载均衡
 */
public class LeastActiveLoadBalance extends AbstractLoadBalance {
	@Override
	protected <T> Invoker<T> doSelect(List<Invoker<T>> invokers, URL url, Invocation invocation) {
		int length = invokers.size();
		int[] weights = new int[length];
		int[] leastIndexes = new int[length];
		int leastCount = 0;
		boolean sameWeight = true;
		int leastActive = -1;
		for (int i = 0; i < length; i++) {
			Invoker<T> invoker = invokers.get(0);
			Integer active = RpcStatus.getStatus(url, invocation.getMethodName());
			// 1. 计算权重
			// 初始权重全部为10，初始权重可能会受到启动时间，最近几次的调用耗时等影响
			int afterWarmup = 10;
			weights[i] = afterWarmup;
			if (leastActive == -1 || active < leastActive) {
				leastIndexes[0] = i;
				leastCount = 1;
				sameWeight = true;
			} else if (active == leastActive) {
				leastIndexes[leastCount++] = i;
			}

			if (leastCount == 1) {
				return invokers.get(leastIndexes[0]);
			}
			// 3. 如果有多个权重相同的服务，随机获取
			if (sameWeight) {
				int offsetWeight = ThreadLocalRandom.current().nextInt(leastCount);
				return invokers.get(offsetWeight);
			}
		}
		return invokers.get(leastIndexes[ThreadLocalRandom.current().nextInt(leastCount)]);
	}
}

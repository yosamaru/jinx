package com.jinx.cluster.support;

import com.jinx.cluster.AbstractCluster;
import com.jinx.cluster.Directory;
import com.jinx.rpc.Invoker;

public class FailbackCluster extends AbstractCluster {
	@Override
	protected <T> Invoker<T> doJoin(Directory<T> directory) {
		return new FailbackClusterInvoker<>(directory);
	}
}

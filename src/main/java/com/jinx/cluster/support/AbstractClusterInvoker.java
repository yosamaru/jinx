package com.jinx.cluster.support;

import com.jinx.cluster.ClusterInvoker;
import com.jinx.cluster.Directory;
import com.jinx.cluster.LoadBalance;
import com.jinx.common.URL;
import com.jinx.rpc.Invocation;
import com.jinx.rpc.Invoker;
import com.jinx.rpc.Result;
import com.jinx.rpc.RpcException;

import java.util.List;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

public abstract class AbstractClusterInvoker<T> implements ClusterInvoker<T> {
    protected Directory<T> directory;

    public AbstractClusterInvoker(Directory<T> directory) {
        this(directory, directory.getUrl());
    }

    public AbstractClusterInvoker(Directory<T> directory, URL url) {
        if (directory == null) {
            throw new IllegalArgumentException("service directory == null");
        }
        this.directory = directory;
    }

    @Override
    public URL getRegistryUrl() {
        return null;
    }

    @Override
    public Directory getDirectory() {
        return null;
    }

    @Override
    public Class getInterface() {
        return directory.getInterface();
    }

	/**容错机制执行模块start=============================================**/
    @Override
    public Result invoke(Invocation invocation) throws RpcException {
        return doInvoke(invocation, null, null);
    }

    protected abstract Result doInvoke(Invocation invocation, List<Invoker<T>> invokers,
                                       LoadBalance loadbalance) throws RpcException;
	/**容错机制执行模块end=============================================**/



	/**路由选择start=============================================**/

	protected Invoker<T> select(LoadBalance loadbalance, Invocation invocation,
	                            List<Invoker<T>> invokers, List<Invoker<T>> selected) throws RpcException {
		if (CollectionUtils.isEmpty(invokers)) {
			return null;
		}

		Invoker<T> invoker = doSelect(loadbalance, invocation, invokers, selected);

		return invoker;
	}

	private Invoker<T> doSelect(LoadBalance loadbalance, Invocation invocation,
	                            List<Invoker<T>> invokers, List<Invoker<T>> selected) throws RpcException {
		if (CollectionUtils.isEmpty(invokers)) {
			return null;
		}
		if (invokers.size() == 1) {
			return invokers.get(0);
		}
		Invoker<T> invoker = loadbalance.select(invokers, getUrl(), invocation);
		return invoker;
	}
	/**路由选择end=============================================**/


	@Override
    public URL getUrl() {
        return null;
    }

    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    public void destroy() {

    }
}

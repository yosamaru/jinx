package com.jinx.register.integration;


import com.jinx.cluster.directory.AbstractDirectory;
import com.jinx.common.URL;
import com.jinx.monitor.NotifyListener;
import com.jinx.rpc.Invocation;
import com.jinx.rpc.Invoker;
import com.jinx.rpc.RpcException;

import java.util.Collections;
import java.util.List;

public class RegistryDirectory<T> extends AbstractDirectory<T> implements NotifyListener {
	private final Class<T> serviceType;
	private volatile List<Invoker<T>> invokers;
	private volatile URL overrideDirectoryUrl;

	public RegistryDirectory(Class<T> serviceType, URL url) {
		super(url);
		if (serviceType == null) {
			throw new IllegalArgumentException("service type is null.");
		}
		this.serviceType = serviceType;
	}

	@Override
    public void destroy() {
		if (isDestroyed()) {
			return;
		}
		invokers = Collections.emptyList();
		// unregister.

		// unsubscribe.

		super.destroy(); // must be executed after unsubscribing
		try {
			// destroyAllInvokers();
		} catch (Throwable t) {

		}
    }

    @Override
    protected List<Invoker<T>> doList(Invocation invocation) throws RpcException {
        return null;
    }

    @Override
    public synchronized void notify(List<URL> urls) {
	    //TODO 监听
    }



    @Override
    public Class<T> getInterface() {
	    return serviceType;
    }

    @Override
    public List<Invoker<T>> getAllInvokers() {
	    return invokers;
    }

    @Override
    public URL getConsumerUrl() {
        return this.overrideDirectoryUrl;
    }


    @Override
    public boolean isAvailable() {

        return false;
    }

}

package com.jinx.protocol;

import com.jinx.common.URL;
import com.jinx.rpc.Invoker;
import com.jinx.rpc.RpcException;

public abstract class AbstractProtocol implements Protocol {
	@Override
	public void destroy() {

	}

	@Override
	public <T> Invoker<T> refer(Class<T> type, URL url) throws RpcException {
		return protocolBindingRefer(type, url);
	}

	protected abstract <T> Invoker<T> protocolBindingRefer(Class<T> type, URL url) throws RpcException;

}

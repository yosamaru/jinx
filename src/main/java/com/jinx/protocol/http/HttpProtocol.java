package com.jinx.protocol.http;

import com.jinx.common.URL;
import com.jinx.protocol.AbstractProtocol;
import com.jinx.rpc.Exporter;
import com.jinx.rpc.Invoker;
import com.jinx.rpc.RpcException;
// 默认http协议
public class HttpProtocol extends AbstractProtocol {
	@Override
	protected <T> Invoker<T> protocolBindingRefer(Class<T> type, URL url) throws RpcException {
		return null;
	}

	@Override
	public int getDefaultPort() {
		return 0;
	}

	@Override
	public <T> Exporter<T> export(Invoker<T> invoker) throws RpcException {
		return null;
	}
}

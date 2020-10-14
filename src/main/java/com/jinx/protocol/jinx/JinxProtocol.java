package com.jinx.protocol.jinx;

import com.jinx.common.URL;
import com.jinx.protocol.AbstractProtocol;
import com.jinx.rpc.Exporter;
import com.jinx.rpc.Invoker;
import com.jinx.rpc.RpcException;
// 自定义协议
public class JinxProtocol extends AbstractProtocol {
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

package com.jinx.protocol;

import java.util.Collections;
import java.util.List;

import com.jinx.common.URL;
import com.jinx.rpc.Exporter;
import com.jinx.rpc.Invoker;
import com.jinx.rpc.RpcException;

public interface Protocol {

	int getDefaultPort();

	<T> Exporter<T> export(Invoker<T> invoker) throws RpcException;


	<T> Invoker<T> refer(Class<T> type, URL url) throws RpcException;

	void destroy();

	default List<ProtocolServer> getServers() {
		return Collections.emptyList();
	}
}

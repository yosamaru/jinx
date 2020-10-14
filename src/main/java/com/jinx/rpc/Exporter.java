package com.jinx.rpc;

public interface Exporter<T> {

	Invoker<T> getInvoker();

	void unexport();
}

package com.jinx.protocol;

import com.jinx.common.URL;
import com.jinx.remoting.RemotingServer;

public interface ProtocolServer {
	default RemotingServer getRemotingServer() {
		return null;
	}

	default void setRemotingServers(RemotingServer server) {
	}

	String getAddress();

	void setAddress(String address);

	default URL getUrl() {
		return null;
	}

	default void reset(URL url) {
	}

	void close();
}

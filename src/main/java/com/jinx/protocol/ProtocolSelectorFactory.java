package com.jinx.protocol;

import com.jinx.protocol.http.HttpProtocol;
import com.jinx.protocol.jinx.JinxProtocol;

public class ProtocolSelectorFactory {
	public static Protocol getProtocol() {
		String name = System.getProperty("protocolName");

		switch (name) {
			case "http":
				return new HttpProtocol();
			case "jinx":
				return new JinxProtocol();
			default:
				break;
		}
		return new HttpProtocol();
	}
}

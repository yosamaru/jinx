package com.jinx.rpc;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.jinx.common.URL;

public class RpcStatus {
	//保存1小时内接口的活跃次数
	private static final Cache<String, Map<String, Integer>> METHOD_STATISTICS = CacheBuilder.newBuilder()
			.maximumSize(Integer.MAX_VALUE)
			.expireAfterWrite(1, TimeUnit.HOURS)
			.build();

	/**
	 * 通过url和methodName获取接口调用次数
	 *
	 * @param url
	 * @param methodName
	 * @return
	 */
	public static Integer getStatus(URL url, String methodName) {
		Map<String, Integer> map = METHOD_STATISTICS.getIfPresent(url);
		return map.computeIfAbsent(methodName, k -> 0);
	}
}

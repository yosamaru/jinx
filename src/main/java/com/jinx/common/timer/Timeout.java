package com.jinx.common.timer;

public interface Timeout {
	Timer timer();

	TimerTask task();

	boolean isExpired();

	boolean isCancelled();

	boolean cancel();
}

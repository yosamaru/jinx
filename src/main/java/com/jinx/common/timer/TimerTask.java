package com.jinx.common.timer;

public interface TimerTask {
	void run(Timeout timeout) throws Exception;
}

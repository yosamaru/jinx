package com.jinx.common.timer;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HashedWheelTimer implements Timer {

	@Override
	public Timeout newTimeout(TimerTask task, long delay, TimeUnit unit) {
		return null;
	}

	@Override
	public Set<Timeout> stop() {
		return null;
	}

	@Override
	public boolean isStop() {
		return false;
	}
}

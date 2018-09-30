package com.chap8.step3;

import java.util.concurrent.ThreadFactory;

public class CustomThreadFactory implements ThreadFactory {
	
	final private String poolName;
	CustomThreadFactory(String poolName) {
		this.poolName = poolName;
	}

	@Override
	public Thread newThread(Runnable r) {
		return new MyThread(r, poolName);
	}

}

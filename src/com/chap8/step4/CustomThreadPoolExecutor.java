package com.chap8.step4;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CustomThreadPoolExecutor extends ThreadPoolExecutor{

	public CustomThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
		// TODO Auto-generated constructor stub
	}

	
	//afterexecute : when task comoetes normally / after throwing exception; but not after error
	//beforeexecute : if exception occurs, execute and afterexecute not called
	//terminated : post shuutdown
	
	
	// we can use tis for logging purpose
}

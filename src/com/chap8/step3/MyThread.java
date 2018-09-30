package com.chap8.step3;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
	
	
	private final static AtomicInteger i = new AtomicInteger();
	MyThread(Runnable r, String poolName){
		super(r, poolName+"_"+i.incrementAndGet() );
		
		setUncaughtExceptionHandler(
				new Thread.UncaughtExceptionHandler() {
					
					@Override
					public void uncaughtException(Thread t, Throwable e) {
						// log
						
					}
				});
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
	}

}

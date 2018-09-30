package com.chap6.step2;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AvailableExecutors {
	
	
	
	public static void main(String[] args) {
		//mainly just separates execution and submission ways
		Executor executor;
		
		//actually creates the thread pool
		//fixed number of threads, if any thread fails new one will come up to match the count
		executor = Executors.newFixedThreadPool(2);
		//only a single thread is created
		Executors.newSingleThreadExecutor();
		//will create thread on need basis (can reuse if idle thread is present; post 60 secs, if thread is idle, it is terminated)
		Executors.newCachedThreadPool();
		//executes the task after specified delay
		Executors.newScheduledThreadPool(3);
		
	}
	
}

package com.chap8.step1;

public class ThreadPoolExecutorMethods {
	
	//1. Executor : only execute available
	//2. ExecutorService : extends Executor and provide lifecycle methods like shutdown, submit, awaitTermination
	//3. AbstractExecutorService : implements ExecutorService with newTaskFor
	//4. ThreadPoolExecutor : base implementation of AbstractExecutorService, has RejectedExecutionHandler, Threadfactory etc
	//5. Executors : Factory for ExecutorService
	
	
	//check ThreadPoolExecutor : corePoolSize, maxoolSize, keepAliveTime etc
	//newFixedThreadPool : pool of fixed number of threads, if one dies and ExecutorService is not shutting down, new thread will be created
	//newCachedThreadPool : can expand to max no. of threads, but creates only whne required
}

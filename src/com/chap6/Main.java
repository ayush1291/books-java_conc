package com.chap6;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

	//Check this interface
	Executor exe = Executors.newFixedThreadPool(4);
	
	//Executor lifecycle
	ExecutorService service;
	
	Executors executors;
	
	//Abstract Executor Service -- check adapter design pattern for runnable to callable
	AbstractExecutorService abs;
	
	
	
	
	Callable<String> call;// check submit method in exe service
	
	//This is for chaned
	Future<String> fiuture;
	
	FutureTask futureTask;
	
	CompletionService sompletionService = new ExecutorCompletionService(exe);
	
	
	
	
	

}

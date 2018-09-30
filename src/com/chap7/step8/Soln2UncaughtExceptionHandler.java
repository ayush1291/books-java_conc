package com.chap7.step8;

//for using tyhis, provide a Threadfactory, to ThreadPoolExecutor constructor
//for standard thread pools, this method lets the thread terminate, but informs the F/W
//works only for tasks submitted using "execute"
//for "submit", the checked/unchecked exception is retured wrapped in ExecutionException
public class Soln2UncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		//use logger and log error message
		// or restart // or ath as per requirement
	}
	
	
	//ThreadPoolExecutor >> runWorker, afterExecute

}

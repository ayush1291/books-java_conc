package com.chap5.futuretask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.FutureTask;

public class Main {

	
	public static void main(String[] args) throws InterruptedException, ExecutionException {

//		ExecutorCompletionService<V>
		FutureTask<String> fu = new FutureTask<String>(new Callable<String>() {

			@Override
			public String call() throws Exception {
				Thread.sleep(2000);
				return "Future";
			}
		});
		new Thread(fu).start();
		System.out.println(fu.get());
	}
	
}

package com.chap5.futuretask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallFuture {
	
	public static void main(String[] args) {
		//Executor srvice 
		ExecutorService executor = Executors.newFixedThreadPool(2);
		Future<String> future =  executor.submit(new MyCall());
		try {
			String res = future.get();
			String res1 = future.get();
			System.out.println(res+" "+res1);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	static class MyCall implements Callable<String>{
		
		@Override
		public String call() throws Exception {
			return "Future";
		}
	}

}

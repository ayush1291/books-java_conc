package com.chap5.futuretask;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;

public class AcceptTaskAsTheyCome {

	public static void main(String[] args) {
		BlockingQueue<Future<String>> block = new LinkedBlockingQueue<>();
		
		for(int i=0; i<10; i++){
			FutureTask<String> f = new FutureTask<>(new MyCall());
			new Thread(f).start();
			block.add(f);
		}
		
		while(true){
			try {
				System.out.println(block.take().get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}

	static class MyCall implements Callable<String> {

		@Override
		public String call() throws Exception {
			Thread.sleep(5000);
			return "Future";
		}
	}
	
	static class MyCall2 implements Callable<String> {

		@Override
		public String call() throws Exception {
			Thread.sleep(1000);
			return "Future2";
		}
	}

}

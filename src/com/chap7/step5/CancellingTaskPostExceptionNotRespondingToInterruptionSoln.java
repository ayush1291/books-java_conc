package com.chap7.step5;

import java.util.Timer;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

//WONT WORK
public class CancellingTaskPostExceptionNotRespondingToInterruptionSoln {

	public static void main(String[] args) {
		A a = new A();
//		a.start();
//		a.interrupt();
		ExecutorService exe = Executors.newSingleThreadExecutor();
		Future<?> future = exe.submit(a);
		try {
			future.get(1000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException | ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (TimeoutException e) {
			System.out.println("Timeout exception");
		}finally{
			System.out.println("cancelling task");
			future.cancel(true);
			System.out.println("cancelled : "+ future.isCancelled() + "*** done : " + future.isDone());
		}
	}
	
	static class A extends Thread {
		
		public void run() {
			while(true){
				//comment out to see that, though canclled was called...still no effect
				//System.out.println("EOWMAITB : " + Thread.currentThread().isInterrupted());
			}
		}
		
		
		//THis method does not get called becz, thread factory of executor is using its own threads and runnable of A
		@Override
		public void interrupt() {
			
			///why is this method not called?????
			System.out.println("here");
			super.interrupt();
		}

	}
	
}

package com.chap7.step5;

import java.util.Timer;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


//post timeout. when we cancel the task, even though the task is cancelled using interruption, the thread continues
//since it was a NOT responsive to interruption, only the interrupt flag was set
public class CancellingTaskPostExceptionNotRespondingToInterruption {

	public static void main(String[] args) {
		A a = new A();
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
				System.out.println("EOWMAITB : " + Thread.currentThread().isInterrupted());
			}
		}

	}
	
}

package com.chap7.step5;

import java.util.Timer;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


//post timeout. when we cancel the task, its sleep is interrupted, so we get InterruptedException and finally the task is cancelled
//since it was a blocking method...i.e. sleep, it responded to interruption
public class CancellingTaskPostException {

	public static void main(String[] args) {
		A a = new A();
		ExecutorService exe = Executors.newSingleThreadExecutor();
		//cheeck submit implemtation
		Future<?> future = exe.submit(a);
		try {
			future.get(1000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException | ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (TimeoutException e) {
			System.out.println("Timeout exception");
		}finally{
			System.out.println("cancelling task, sleep will be interrupted now");
			future.cancel(true);
			System.out.println("cancelled : "+ future.isCancelled() + "*** done : " + future.isDone());
		}
	}
	
	static class A extends Thread {
		
		public void run() {
			System.out.println("A");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				System.out.println("Interruption handled");
			}
			
		}

	}
	
}

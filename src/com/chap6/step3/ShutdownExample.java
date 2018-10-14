package com.chap6.step3;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//TODO-- see working of scheduled delay

public class ShutdownExample {

	public static void main(String[] args) {
		
		ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		System.out.println("starting mei is terminated :" + executorService.isTerminated());
		System.out.println("starting mei is shutdown :" + executorService.isShutdown());
		try {
			executorService.scheduleAtFixedRate(new Runnable(){
				@Override
				public void run() {
					System.out.println("Task  submitted");
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}, 0, 1, TimeUnit.SECONDS);
			
			Thread.sleep(2000);
			executorService.shutdown();
			System.out.println("post shutdown req is terminated :" + executorService.isTerminated());
			System.out.println("post shutdown req is shutdown :" + executorService.isShutdown());
			executorService.scheduleAtFixedRate(new Runnable(){
				@Override
				public void run() {
					System.out.println("Task  submitted post shutdown");
				}
			}, 0, 1, TimeUnit.SECONDS);
		}
		catch(RejectedExecutionException rej){
			System.out.println("Task moved to rejection queue");
		}catch(InterruptedException rej){
			System.out.println("Task interrupted");
		}
		System.out.println("is terminated :" + executorService.isTerminated());
		System.out.println("is shutdown :" + executorService.isShutdown());
	}
}

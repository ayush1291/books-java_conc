package com.chap6.step3;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//ayush
public class ShutdownExample2 {

	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		System.out.println("starting mei is terminated :" + executorService.isTerminated());
		System.out.println("starting mei is shutdown :" + executorService.isShutdown());
		try {
			for(int i=0; i<10; i++){
				executorService.execute(new Runnable(){
					@Override
					public void run() {
						System.out.println("Task  submitted");
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				});
			}
						
			executorService.shutdown();
			System.out.println("Add post shutdown");
			executorService.execute(new Runnable(){
				@Override
				public void run() {
					System.out.println("Task  submitted post shutdown");
				}
			});
			System.out.println("post shutdown req is terminated :" + executorService.isTerminated());
			System.out.println("post shutdown req is shutdown :" + executorService.isShutdown());
			boolean termination = executorService.awaitTermination(1, TimeUnit.MILLISECONDS);
			System.out.println("termination" + termination);
			System.out.println("nowwwwww");
			List<Runnable> leftTasks = executorService.shutdownNow();
			System.out.println("*******" +leftTasks.size());
		}
		catch(RejectedExecutionException rej){
			System.out.println("Task moved to rejection queue");
		}
		catch(InterruptedException rej){
			System.out.println("Task interrupted");
		}
		System.out.println("is terminated :" + executorService.isTerminated());
		System.out.println("is shutdown :" + executorService.isShutdown());
	}
}

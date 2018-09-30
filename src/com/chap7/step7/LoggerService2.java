package com.chap7.step7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;



public class LoggerService2 {

	private final ExecutorService exe = Executors.newSingleThreadExecutor();
	int i = 0;
	private List<Runnable> failedTasks = new ArrayList<>();
	
	void  put(String msg) throws InterruptedException{
		try {
			A a = new A();
			exe.execute(a);
		} catch (RejectedExecutionException e) {
			System.out.println("Rejected as added post shutdown : " + msg);
		}
		
	}
		

	void stop(){
		exe.shutdown();
		try {
			exe.awaitTermination(10, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Runnable> list = exe.shutdownNow();
		System.out.println("size of tasks submitted but not satrted : " + list.size());
	}
	
	
	List<Runnable> getFailedTasks() {
		return failedTasks;
	}
	
	class A implements Runnable{
			@Override
			public void run() {
				try {
					Thread.sleep(1);
					System.out.println("msg : " + ++i);
				} catch (InterruptedException e) {
					System.out.println("running task is cancelled : " + i);
					Thread.currentThread().interrupt();
				} finally {
					if(exe.isShutdown() && Thread.currentThread().isInterrupted()){
						failedTasks.add(this);
					}
				}
				
			}
	}
	
}

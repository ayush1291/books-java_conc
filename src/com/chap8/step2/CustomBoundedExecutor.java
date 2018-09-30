package com.chap8.step2;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

public class CustomBoundedExecutor {
	private final Executor exec;
	private final Semaphore semaphore;
	
	CustomBoundedExecutor(Executor exec, int bound) {
		this.exec = exec;
		this.semaphore = new Semaphore(bound);
	}
	
	public void submitTask(final Runnable command) throws InterruptedException {
		semaphore.acquire();
		try{
			exec.execute(new Runnable(){
				@Override
				public void run() {
					try{
						command.run();
					}
					finally{
						semaphore.release();
					}
				}
			});
		} catch (RejectedExecutionException rej) {
			semaphore.release();
		}

	}
}

package com.chap6;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class HandlingShutDownInExecutorService {
	
	public static void main(String[] args) {
		
		ExecutorService service = new MyExeService();
		
		for(int i=0; i<10; i++){
			
			try{
				service.execute(new Runnable() {
					
					@Override
					public void run() {
						
					}
				});
			}catch(RejectedExecutionException e){
				System.out.println("Cannot submit more tasks");
			}
			
			
			if(i==5){
				service.shutdown();
			}
		}
		
		
	}
	
	
	static class MyExeService implements ExecutorService {
		
		private volatile boolean shutDown;
		
		@Override
		public void execute(Runnable command) throws RejectedExecutionException{
			if(shutDown){
				throw new RejectedExecutionException();
			}else{
				System.out.println("Running a task ");
			}
		}
		
		@Override
		public <T> Future<T> submit(Runnable task, T result) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Future<?> submit(Runnable task) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <T> Future<T> submit(Callable<T> task) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public List<Runnable> shutdownNow() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public void shutdown() {
			shutDown=true;
			
		}
		
		@Override
		public boolean isTerminated() {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean isShutdown() {
			// TODO Auto-generated method stub
			return shutDown;
		}
		
		@Override
		public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
				throws InterruptedException, ExecutionException, TimeoutException {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
				throws InterruptedException {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
			// TODO Auto-generated method stub
			return false;
		}
	};

}

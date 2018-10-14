package com.chap7.step5;

import java.util.Timer;
import java.util.concurrent.*;

//main funda is to oveeride cancel method of future, to cancel activities NOT responsive to interruption
// this can be done by creating your custom executor service
public class CancellingTaskPostExceptionNotRespondingToInterruptionSolution {

	public static void main(String[] args) {
		
		ExecutorService exe = new MyExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
		CallableTask c = new CallableTaskClass();
		Future<String> future = exe.submit(c);
		try {
			future.get(1000, TimeUnit.MICROSECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("Cancelling task");
			future.cancel(true);
			System.out.println("Cancelled taskk*********");
			
		}
		
	}
	
	

	static interface CallableTask extends Callable<String> {
		void cancel();
		RunnableFuture<String> newTask();
		
	}
	
	
	
	
	//Alternative strategy--
	
	static class MyFuture<V> extends FutureTask<V>{
		
		Callable<V> calla ;
		

		public MyFuture(Callable<V> callable) {
			super(callable);
			this.calla=callable;
		}
		
		@Override
		public boolean cancel(boolean mayInterruptIfRunning) {
			return super.cancel(mayInterruptIfRunning);
		}
		
	}
	
	
	static class CallableTaskClass implements CallableTask {

		@Override
		public String call() throws Exception {
			while(true){
				System.out.println("A");
			}
		}

		@Override
		public void cancel() {
			System.out.println("Cancel and clean up of Callable");
			
		}

		@Override
		public RunnableFuture<String> newTask() {
			return new FutureTask<String>(this) {
				@Override
				public boolean cancel(boolean mayInterruptIfRunning) {
					System.out.println("Cancel and clean up --> so call this class ka cancel");
					CallableTaskClass.this.cancel();
					System.out.println("Now u can callnrml cancel");
					return super.cancel(mayInterruptIfRunning);
				}
			};
		}
		
		
	}
	
	
	static class MyExecutor extends ThreadPoolExecutor {

		public MyExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
				BlockingQueue<Runnable> workQueue) {
			super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
		}
		
		@Override
		protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
			if (callable instanceof CallableTask) {
				return (RunnableFuture<T>) ((CallableTask) callable).newTask();
			}
			return super.newTaskFor(callable);
		}
		
	}
	
}

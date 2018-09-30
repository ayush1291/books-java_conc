package com.chap7.step5;

import java.util.Timer;
import java.util.concurrent.*;

//main funda is to oveeride cancel method of future, to cancel activities NOT responsive to interruption
// this can be done by creating your custom executor service
public class CancellingTaskPostExceptionNotRespondingToInterruptionSolution {

	public static void main(String[] args) {
	}
	
	

	static interface CallableTask extends Callable<String> {
		void cancel();
		RunnableFuture<String> newTask();
		
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
					System.out.println("Cancel and clean up");
					return super.cancel(mayInterruptIfRunning);
				}
			};
		}
		
		
	}
	
}

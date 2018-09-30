package com.chap6.step1;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ProblemStmtAndSoln {
	//processing request one by one
	public static void step1(String[] args) {
		while(true){
			//acceptRequest
			//processRequest
		}
	}
	 //or
	class SingleThreadedExecutor implements Executor {
		@Override
		public void execute(Runnable command) {
			command.run();
		}
	}
	
	//process in a thread...don't wait
	// but like this multiple threads will be created, so
	//thread life cycle maintenance and resource consumption problem occurs
	//also we may run out of memory
	public static void step2(String[] args) {
		while(true){
			//acceptRequest
			new Thread(){
				public void run() {
					//processRequest
				};
			}.start();
		}
	}
	//or
	class NewThreadAlwaysExecutor implements Executor {
		@Override
		public void execute(Runnable command) {
			new Thread(command).start();
		}
	}
	
	
	//best
	public static void step3(String[] args) {
		Executor exec = Executors.newFixedThreadPool(4);
		Runnable task = new Runnable(){
			@Override
			public void run() {
				// processrequest	
			}
		};
		exec.execute(task);
	}
}

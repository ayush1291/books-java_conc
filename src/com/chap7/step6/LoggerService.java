package com.chap7.step6;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


///normal....wont stop and will keep on logging
//but we have to stop this one..so that eventually our JVM can exit...so uncomment ######
//still JVM won't stop as some threads are now waiting on PUT call
//so if we STOP cosnumer, PRODUCER should also be sstopped and other msgs, which were in the
//queue should be handled
public class LoggerService {

	private static final BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
	private static LoggerThread thread = new LoggerThread();
	
	public static void main(String[] args) throws InterruptedException {
		thread.start(); 
		for (int i =0; i<15; i++) {
			put(i+"");
			//######
//			if (i == 8) {
//				thread.interrupt();
//			}
		}
	 System.out.println("Main exits, JVM is running" + thread.getState().name());
	}
	
	static void  put(String msg) throws InterruptedException{
		System.out.println("Add in queue " + msg);
		queue.put(msg);
	}
	
	static class LoggerThread extends Thread {
		@Override
		public void run() {
			
			try {
				while(true){
					System.out.println("Fetch form queue");
					Thread.sleep(1000);
					System.out.println(queue.take());
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
}

package com.chap7.step6;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


///one solution was to keep a flag shutdownrequested and then not sumbit more msgs, 
//once cancellationis requested..and process the blocked and in queue msgs
//still msgs that are bblocked due to put will be stuck always
//so we follow this approach
public class LoggerService2 {

	private final BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
	private LoggerThread thread = new LoggerThread();
	private boolean isShutdown;
	private int reservations;
	
	void  put(String msg) throws InterruptedException{
		synchronized(this){
			System.out.println("Check shutdown flag " + isShutdown);
			if (isShutdown){
				System.out.println("PUT not allowed **********");
				return;
			}	
			reservations++;
			
		}
		System.out.println("Add in queue " + msg);
		queue.put(msg);
	}
		
	void start(){
		thread.start();
	}
	
	void stop(){
		synchronized(this){
			isShutdown=true;
		}
		thread.interrupt();
	}
	
	class LoggerThread extends Thread {
		@Override
		public void run() {
			
			while(true){
				try {
					synchronized(this){
						if(isShutdown && reservations==0)
							break;
					}
					System.out.println("Fetch form queue");
					String msg = queue.take();
					synchronized(this){
						--reservations;
					}
					Thread.sleep(1000);
					System.out.println("Print : "+msg);
				} catch (InterruptedException e) {
					System.out.println("Writer thread interrupted");
				}
			}	
		}
	}
	
}

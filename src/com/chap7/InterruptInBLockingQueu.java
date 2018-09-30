package com.chap7;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class InterruptInBLockingQueu {
	
	//This code wont work fine if I use cancellation policy
	
	static BlockingQueue<String> queue = new LinkedBlockingQueue<String>(2);
	
	public static void main(String[] args) throws InterruptedException {
		Thread th = new Thread(new MyRun());
		th.start();
		Thread.sleep(1000);
		th.interrupt();
	}
	
	
	
	static class MyRun implements Runnable{
		
		
		@Override
		public void run() {
		try{
			while(!Thread.currentThread().isInterrupted()){
				queue.put(calcNext());
				System.out.println("Value is put");
				
			}
		}catch(InterruptedException e){
			System.out.println("Status after checking "+Thread.currentThread().isInterrupted());
			e.printStackTrace();
		}
		}
	}
	
	static String calcNext(){
		return "abc";
	}
	
}

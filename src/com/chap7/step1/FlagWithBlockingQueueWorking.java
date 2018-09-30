package com.chap7.step1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class FlagWithBlockingQueueWorking {

public static void main(String[] args) throws InterruptedException {
		
		PrimeGenerator pg  = new PrimeGenerator();
		new Thread(pg).start();
		try {
			Thread.sleep(1);
			for (int i = 0; i<2; i++) {
				System.out.println(pg.getPrime() + "***");
			}
		}finally {
			System.out.println("Cancel called");
			pg.cancel();
		}
		
	}
	
	
	static class PrimeGenerator implements Runnable{
		
		private BlockingQueue<Integer> primes = new ArrayBlockingQueue(1000000);
		private volatile boolean cancelled;
		
		@Override
		public void run() {
			while(!cancelled){
				synchronized(this){
					try {
						System.out.println("in thread....trying to put");
						primes.put(new Random().nextInt(20));
						System.out.println("in thread....put done");
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						System.out.println("InterruptedException ignored");
					}
				}
			}
		}
		
		public void cancel(){
			System.out.println("Cancelling");
			cancelled = true;
		}
		
		public synchronized Integer getPrime() throws InterruptedException {
			return primes.take();
		}
	}
}

package com.chap7.step1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class FlagWithBlockingQueue {

	//this one may / may not work....
	//not reliable as this flag will not be seen by a thread thats blocked due to put call
	// this is corrected in step 2
public static void main(String[] args) throws InterruptedException {
		
		PrimeGenerator pg  = new PrimeGenerator();
		new Thread(pg).start();
		try {
			
			for (int i = 0; i<2; i++) {
				System.out.println(pg.getPrime() + "***");
			}
			Thread.sleep(100);
		}finally {
			System.out.println("Cancel called");
			pg.cancel();
		}
		
	}
	
	
	static class PrimeGenerator implements Runnable{
		
		private BlockingQueue<Integer> primes = new ArrayBlockingQueue(5);
		private volatile boolean cancelled;
		
		@Override
		public void run() {
			while(!cancelled){
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
		
		public void cancel(){
			System.out.println("Cancelling");
			cancelled = true;
		}
		
//		my stupidity...both set and get synchronized...th chala hi nhi ye :P
//		public synchronized Integer getPrime() throws InterruptedException {
//			return primes.take();
//		}
		
		public Integer getPrime() throws InterruptedException {
			return primes.take();
		}
	}
}

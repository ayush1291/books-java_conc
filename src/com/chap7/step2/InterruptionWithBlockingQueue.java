package com.chap7.step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class InterruptionWithBlockingQueue {

	//here interrption is checked evrytime before proceeding
	//so even if thread i sblokced in put, it will work
public static void main(String[] args) throws InterruptedException {
		
		PrimeGenerator pg  = new PrimeGenerator();
		pg.start();
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
	
	
	static class PrimeGenerator extends Thread{
		
		private BlockingQueue<Integer> primes = new ArrayBlockingQueue(5);
		
		@Override
		public void run() {
			
			try {
				while(!Thread.currentThread().isInterrupted()){
					System.out.println("in thread....trying to put");
					primes.put(new Random().nextInt(20));
					System.out.println("in thread....put done");
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// ideally wrong
				System.out.println("InterruptedException ignored");
			}
		}
		
		public void cancel(){
			System.out.println("Cancelling");
			interrupt();
		}
		
		public Integer getPrime() throws InterruptedException {
			return primes.take();
		}
	}
}

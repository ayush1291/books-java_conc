package com.chap7.step1;

import java.util.ArrayList;
import java.util.List;

//this works firn here, but will fail in FlagWithBlockingQueue
public class BasicUsingFlag {

	public static void main(String[] args) throws InterruptedException {
		
		PrimeGenerator pg  = new PrimeGenerator();
		new Thread(pg).start();
		try {
			Thread.sleep(1);
		}finally {
			System.out.println("Cancel called");
			pg.cancel();
		}
		
		System.out.println(pg.getPrimes().size() + "***");
	}
	
	
	static class PrimeGenerator implements Runnable{
		
		private List<Integer> primes = new ArrayList<>();
		private volatile boolean cancelled;
		
		@Override
		public void run() {
			while(!cancelled){
				synchronized(this){
					System.out.println("in thread");
					primes.add(new Integer("2"));
				}
			}
		}
		
		public void cancel(){
			System.out.println("Cancelling");
			cancelled = true;
		}
		
		public synchronized List<Integer> getPrimes() {
			return new ArrayList<>(primes);
		}
	}
}

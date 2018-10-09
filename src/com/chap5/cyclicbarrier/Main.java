package com.chap5.cyclicbarrier;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

//In case when barrier is reset and previous await ??


public class Main {
	
	private int WORKERS=5;
	private int NUMBER_OF_PARTIAL=3;
	AtomicReference<List<Integer>> nos = new AtomicReference(new ArrayList<Integer>());
	Random ran = new Random();
	private CyclicBarrier barrier;
	
	public static void main(String[] args) {
		Main main = new Main();
		main.barrier  = new CyclicBarrier(main.WORKERS, main.new Agg());
		for(int i=0; i<main.WORKERS; i++){
			(new Thread(main.new Worker())).start();
		}
	}
	
	public class Worker implements Runnable{

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run() {
			System.out.println("Worker is running "+Thread.currentThread().getName());
			int total=0;
			for(int i=0; i<NUMBER_OF_PARTIAL; i++){
				total+=ran.nextInt(10);
			}
			final Integer res = new Integer(total);
			nos.get().add(res);
			System.out.println("Worker is waiting "+Thread.currentThread().getName()+" total "+total);
			try {
//				barrier.await(1,TimeUnit.MILLISECONDS);
				barrier.await();
				System.out.println("Done now for "+Thread.currentThread().getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				System.out.println(System.currentTimeMillis()+"****************************");
//				e.printStackTrace();
			} 
//			catch (TimeoutException e) {
//				System.out.println(System.currentTimeMillis()+"*********************************************");
//			}
		}
		
	}
	
	class Agg implements Runnable{
		
		@Override
		public void run() {
			System.out.println("Now aggregating "+Thread.currentThread().getName());
			
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			
			int total =0;
			for(int i=0; i<nos.get().size(); i++){
				if(nos.get().get(i)==null) System.out.println("Is null "+nos.get().size());
				System.out.println(i);
				total+=nos.get().get(i);
			}
			System.out.println("Total is "+total);
		}
	}
	
	

}

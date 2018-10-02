package com.chap5.latch;

//WHy reset is not allowed in latch

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Main {

	private CountDownLatch latch = new CountDownLatch(1);
	private CountDownLatch end = new CountDownLatch(5);

	public static void main(String[] args) {

		Main ma = new Main();
		ma.start();
//		ma.start2();
		long st = System.currentTimeMillis();
		ma.latch.countDown();
		
		//If already countdown is done
//		try {
//			System.out.println("Trying to await now************************8");
//			ma.latch.await();
//		} catch (InterruptedException e1) {
//			e1.printStackTrace();
//		}
//		
		System.out.println("After trying to await there**************************");
		try {
			ma.end.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("All ended");
		System.out.println(System.currentTimeMillis()-st);

	}

	public void start() {
		for (int i = 0; i < 5; i++) {
			new Thread() {
				@Override
				public void run() {
					try {
						System.out.println("Waiting " + Thread.currentThread().getName()+" "+System.currentTimeMillis());
						latch.await();
						System.out.println("Started running " + Thread.currentThread().getName() + " "+System.currentTimeMillis());
					} catch (InterruptedException e) {
						
					}
					end.countDown();
				}
			}.start();
		}

	}
	
	
	//Interruption - time out
	public void start2() {
		for (int i = 0; i < 100; i++) {
			new Thread() {
				@Override
				public void run() {
					try {
						System.out.println("Waiting " + Thread.currentThread().getName()+" "+System.currentTimeMillis());
						latch.await(1,TimeUnit.MILLISECONDS);
						System.out.println("Started running " + Thread.currentThread().getName() + " "+System.currentTimeMillis());
					} catch (InterruptedException e) {
						System.out.println("Interrupted "+Thread.currentThread().getName());
					}
					end.countDown();
				}
			}.start();
		}

	}

}

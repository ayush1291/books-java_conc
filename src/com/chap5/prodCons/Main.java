package com.chap5.prodCons;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

//If work stealing is used anywhere, then contention will not happen, will be more scalable - more suited when consu and prod are same
//Web crawlers use this thing of work stealing

public class Main {

	static BlockingQueue<Integer> block = new LinkedBlockingDeque<>();

	public static void main(String[] args) throws InterruptedException {

		new Thread() {
			public void run() {
				Producer prod = new Producer();
				try {
					for (int i = 0; i < 10; i++){
						System.out.println("Let them contend");
						Thread.sleep(2000);
						System.out.println("Giving one value");
						prod.produce();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			};
		}.start();

		new Thread() {
			public void run() {
				Consumer cons2 = new Consumer();
				while (1 == 1)
					cons2.consumer();
			};
		}.start();

		new Thread() {
			public void run() {
				Consumer cons3 = new Consumer();
				while (1 == 1)
					cons3.consumer();
			};
		}.start();
	}

	static class Producer {
		Random ran = new Random();

		public void produce() throws InterruptedException {
			block.put(ran.nextInt(10));
		}
	}

	static class Consumer {

		public void consumer() {
			try {
				System.out.println(Thread.currentThread().getName() + " Took value " + block.take());
			} catch (InterruptedException e) {
			}
		}
	}

}

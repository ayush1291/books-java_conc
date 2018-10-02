package com.chap5.blockingqueue;

import java.util.concurrent.SynchronousQueue;

//This is a second way to implement prod consumer design, one was 	blocking queue(wait and notify)

//If no Thread to recieve, put will be blocked.

//Later- check the working
public class Synchronous {
	
	public static void main(String[] args) throws InterruptedException {
		final SynchronousQueue<Integer> syn = new SynchronousQueue<>();
		new Thread(){
			public void run() {
				try {
					System.out.println(syn.take());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			};
		}.start();
		new Thread(){
			public void run() {
				try {
					System.out.println(syn.take());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			};
		}.start();
		
		syn.put(2);
		syn.put(3);
	}

}

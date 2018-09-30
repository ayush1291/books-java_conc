package com.multithreading.javaConcurrencyInPrac.chap4.step5;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class MultipleDelegationPassTest {
	
	public static void main(String[] args) throws InterruptedException {
		
		MultipleDelegationPass multipleDelegationFails = new MultipleDelegationPass();
		Thread thread1 = new Thread() {
			@Override
			public void run() {
				System.out.println("Thread 1");
				try {
					System.out.println("Set upper 5");
					multipleDelegationFails.setUpper(5);
					System.out.println("Validate : " + multipleDelegationFails.validate());
					Thread.sleep(2000);
					System.out.println("Set upper 1");
					multipleDelegationFails.setUpper(1);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		Thread thread2 = new Thread() {
			@Override
			public void run() {
				System.out.println("Thread 2");
				try {
					System.out.println("Set upper 20");
					multipleDelegationFails.setUpper(20);
					System.out.println("Set lower 10");
					multipleDelegationFails.setLower(10);
					System.out.println("Thread 1 join called");
					thread1.join();
					System.out.println("Thread 1 join finished");
					System.out.println("Validate : " + multipleDelegationFails.validate());
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		thread1.start();
		Thread.sleep(1000);
		thread2.start();
		
	}
	
	
}

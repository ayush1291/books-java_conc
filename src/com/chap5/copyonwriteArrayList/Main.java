package com.chap5.copyonwriteArrayList;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

//Check how reentrant lock is working

//Mostly used when iterator is common than modification

public class Main {
	
	
	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		
		
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
					list.add("a");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}).start();;
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
					list.add("a");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}).start();;
		
		
		
		list.get(0);
		
	}

}

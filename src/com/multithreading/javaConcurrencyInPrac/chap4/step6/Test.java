package com.multithreading.javaConcurrencyInPrac.chap4.step6;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

//live picture returned
public class Test {

	public static void main(String[] args) {
		
		Map<String, MutablePoint> map = new HashMap<>();
		map.put("1", new MutablePoint(1,1));
		map.put("2", new MutablePoint(2,2));
		map.put("3", new MutablePoint(3,3));
		Tracker tracker = new Tracker(map);
		
		Thread thread1 = new Thread(){
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					tracker.setLocations("1", 11, 11);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		
		Thread thread2 = new Thread(){
			@Override
			public void run() {
				System.out.println("Iterate over map in thread 2");
				Map<String, MutablePoint> map1 = tracker.getLocations();
				Iterator itr = map1.entrySet().iterator();
				while(itr.hasNext()){
					Entry entry = (Entry) itr.next();
					System.out.println(entry.getKey() + " : " + entry.getValue().toString());
				}
				try {
					thread1.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Iterate again in thread 2");
				itr = map1.entrySet().iterator();
				while(itr.hasNext()){
					Entry entry = (Entry) itr.next();
					System.out.println(entry.getKey() + " : " + entry.getValue().toString());
				}
			}
		};
		
		thread1.start();
		thread2.start();
	}
}

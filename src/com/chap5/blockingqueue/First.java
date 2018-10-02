package com.chap5.blockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class First {
	
	//How long can i put values in non bounded queue
	
	//try with offer method and put method
	
	//Max Capacity for an unbounded one is Integer.MAX
	
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Integer> bl = new LinkedBlockingQueue<>(2);

//		BlockingQueue<Integer> bl = new LinkedBlockingQueue<>();
		
		int i=1;
		while(1==1){
//			bl.offer(2);
//			bl.put(2);
//			bl.add(2);
			System.out.println(bl.offer(2));
			System.out.println(i++);
		}
		
	}

}

package com.multithreading.javaConcurrencyInPrac.chap3.step1;


//here, there are two possibilities...
//1. It prints number as 0
//2. Keeps on looping, since value of ready is NOT visible to reader thread

//why??? : coz NO synchronization, implies THESE operation s can be reordered....
//so the thread may see these assignments in opposite order OR no values assigned at all 

//so, NEVER share variables without sync
public class NoVisibility {

	private static boolean ready;
	private static int number;
	
	public static class ReaderThread extends Thread {
		public void run() {
			while(!ready)
				// it gives hint to the thread scheduler that it is ready to pause its execution. Thread scheduler is free to ignore this hint.
				Thread.yield();
			System.out.println(number);
		}
	}
	public static void main(String[] args) {
		
		new ReaderThread().start();
		number = 42;
		ready = true;
	}
}

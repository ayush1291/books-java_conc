package com.multithreading.basics.lockingConceptsInhertance;

public class TestClass {
	public static void main(String[] args) {
		
		Thread thread1 = new Thread(new Runnable1());
		Thread thread2 = new Thread(new Runnable2());
		thread1.start();
//	  try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	  thread2.start();
	  
	}
	
	static class  Runnable1 implements Runnable {

		@Override
		public void run() {
			Child child = new Child();
			child.printMessage();
			
		}
		
	}
	
	static class Runnable2 implements Runnable {

		@Override
		public void run() {
			Parent parent = new Parent();
			parent.printMessage();
		}
		
	}
}

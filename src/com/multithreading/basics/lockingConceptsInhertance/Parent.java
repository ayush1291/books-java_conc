package com.multithreading.basics.lockingConceptsInhertance;

public class Parent {

	public synchronized void printMessage() {
		
		
		 System.out.println("in Parent : during calling : Parent : holding lock : " + Thread.holdsLock(this));
		 try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		System.out.println("Parent method called");
		
		
	}
}

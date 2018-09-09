package com.multithreading.basics.lockOnObjectForSubClass;

public class Parent {

	public synchronized void printMessage() {
		 System.out.print("in Parent : during calling : Parent : holding lock : " + Thread.holdsLock(this));

		System.out.println("Parent method called");
		
	}
}

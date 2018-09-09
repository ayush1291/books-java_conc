package com.multithreading.basics.lockOnObjectForSubClass;

public class Child extends Parent{

	@Override
	public synchronized void printMessage() {
		System.out.println("Child method called");
		 System.out.println("during calling : child : holding lock : " + Thread.holdsLock(this));
		super.printMessage();
	}
}

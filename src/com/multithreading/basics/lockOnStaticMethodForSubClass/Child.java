package com.multithreading.basics.lockOnStaticMethodForSubClass;

public class Child extends Parent{

	//@Override : removed (compilation error)
	
	public static synchronized void printMessage() {
		System.out.println("Child method called");
		System.out.println("Child class : lock on child" + Thread.holdsLock(Child.class));
		System.out.println("Child class : lock on parent" + Thread.holdsLock(Parent.class));
try {
	Thread.sleep(10000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		//super.printMessage(); //not allowed
	}
}

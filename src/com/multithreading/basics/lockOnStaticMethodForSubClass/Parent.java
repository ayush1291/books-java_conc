package com.multithreading.basics.lockOnStaticMethodForSubClass;

public class Parent {

	public static synchronized void printMessage() {
		
		System.out.println("Parent method called");
		System.out.println("Parent class : lock on child" + Thread.holdsLock(Child.class));
		System.out.println("Parent class : lock on parent" + Thread.holdsLock(Parent.class));
		
	}
}

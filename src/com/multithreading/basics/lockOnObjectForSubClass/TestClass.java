package com.multithreading.basics.lockOnObjectForSubClass;

public class TestClass {
	public static void main(String[] args) {
	  Child child = new Child();
	  System.out.println("in main : b4 calling : child : holding lock : " + Thread.holdsLock(child));
	  child.printMessage();
	  System.out.println("in main : after calling : child : holding lock : " + Thread.holdsLock(child));
			  
	  
	  System.out.print("Checking the other one");
	  Parent parent = new Parent();
	  System.out.println("in main : b4 calling : parent : holding lock : " + Thread.holdsLock(parent));
	  parent.printMessage();
	  System.out.println("in main : after calling : parent : holding lock : " + Thread.holdsLock(parent));
	}
}

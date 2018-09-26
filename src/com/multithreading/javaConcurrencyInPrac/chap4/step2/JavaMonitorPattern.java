package com.multithreading.javaConcurrencyInPrac.chap4.step2;

//Whjat is intrinsic lock
//What is monitor pattern

public class JavaMonitorPattern {

	private final Object myLock = new Object();
	public static void main(String[] args) {
		JavaMonitorPattern java= new JavaMonitorPattern();
		java.doSomething();
	}
	
	
	void doSomething() {
		synchronized (myLock) {
			Thread.holdsLock(myLock);
			///do something
		}
	}
}

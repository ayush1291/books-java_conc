package com.multithreading.javaConcurrencyInPrac.chap4.step2;

public class JavaMonitorPattern {

	private final Object myLock = new Object();
	
	void doSomething() {
		synchronized (myLock) {
			///do something
		}
	}
}

package com.multithreading.javaConcurrencyInPrac.chap3.step2;


//if we use getter and setter without sync, we may see stale value or loose an update
//both operations SET and GET must be v
public class StaleDataIssues {

	private int a;

//	public int getA() {
//		return a;
//	}
//
//	public void setA(int a) {
//		this.a = a;
//	}
	
	
	
	public synchronized int getA() {
		return a;
	}

	public synchronized void setA(int a) {
		this.a = a;
	}
	
	
}

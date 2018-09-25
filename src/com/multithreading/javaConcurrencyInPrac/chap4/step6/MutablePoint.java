package com.multithreading.javaConcurrencyInPrac.chap4.step6;


//mutable but thread safe 
//if separate geteers, there is a possiblity of getting x from 1 thread, and y set by another
public class MutablePoint {
	private int x, y;
	
	public MutablePoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public synchronized int[] get(){
		return new int[] {x, y};
	}
	
	public synchronized void set(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "x: " + x + ", y: " + y;
	}
}

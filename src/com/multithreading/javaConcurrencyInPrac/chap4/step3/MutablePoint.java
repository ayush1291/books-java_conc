package com.multithreading.javaConcurrencyInPrac.chap4.step3;

public class MutablePoint {
	int x, y;
	
	public MutablePoint() {
		x = 0;
		y = 0;
	}
	
	public MutablePoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public MutablePoint(MutablePoint m) {
		this.x = m.x;
		this.y = m.y;
	}
	
	@Override
	public String toString() {
		return "x: " + x + ", y: " + y;
	}
}

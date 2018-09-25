package com.multithreading.javaConcurrencyInPrac.chap4.step4;

public class ImmutablePoint {
	private final int x, y;
	
	public ImmutablePoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "x: " + x + ", y: " + y;
	}
}

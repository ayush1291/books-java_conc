package com.multithreading.javaConcurrencyInPrac.chap4.step5;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class MultipleDelegationPass {
	private final AtomicInteger upper = new AtomicInteger(0);
	private final AtomicInteger lower = new AtomicInteger(0);
	
	//here our invariant is  lower<upper
	
	
	//individually, these are atomic, but as a whole, there is a chance of failure
	//so only delegation will fail.....use extra locking
	
	public void setUpper (int i) throws Exception{
		if (i > lower.get()) {
			upper.set(i);
		}else {
			throw new Exception();
		}
		
	}
	
	public void setLower (int i) throws Exception{
		if (i < upper.get()) {
			Thread.sleep(4000);
			lower.set(i);
		}else {
			throw new Exception();
		}
		
	}
	
	public boolean validate(){
		return lower.get() <= upper.get();
	}
	
	
}

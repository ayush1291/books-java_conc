package com.multithreading.javaConcurrencyInPrac.chap3.step3.soln;

import java.util.EventListener;

public class PublishingSolution {
	
	//1. Never publish inside constructor, as object is not in consistent state
	//So...don't allow this to escape during construction
	//2. Don't call an overridable method from constructor
	
	private Thread a;
////////
	private final EventListener eventListener;

	//creation is fine....NOT starting
	private PublishingSolution(){
		a = new Thread() {
			public void run() {
				
			}
		};
		eventListener = new EventListener(){
			//some code here
		};
	}
	
	//still fine as u r creating it in constructor..but NOT escaoing it
	public void startMyThread() {
		a.start();
	}
	
	public static PublishingSolution getInsatnce() {
		PublishingSolution ps = new PublishingSolution();
		return ps;
	}
	
	
	
	
}

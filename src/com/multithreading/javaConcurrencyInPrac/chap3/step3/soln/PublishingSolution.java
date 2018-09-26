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
		//eg1
		a = new Thread() {
			public void run() {
				
			}
		};
		
		//eg2
		eventListener = new EventListener(){
			//some code here
		};
	}
	
	//still fine as u r creating it in constructor..but NOT escaping it
	//eg1 (soln to problem #4 in prev class)
	public void startMyThread() {
		a.start();
	}
	
	
	//eg2
	public static PublishingSolution getInsatnce(EventSource source) {
		//see that constructor is private
		PublishingSolution ps = new PublishingSolution();
		//here, we are solving problem #5 faced in last class and registering the event listener post proper creation
		source.register(ps.eventListener);
		return ps;
	}
	
	
	class EventSource{
		void register(EventListener eventListener){
			//code 
		}
	}
	
}

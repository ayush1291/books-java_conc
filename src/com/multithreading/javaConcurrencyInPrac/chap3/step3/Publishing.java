package com.multithreading.javaConcurrencyInPrac.chap3.step3;

import java.util.EventListener;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Publishing {
	
	
	public static Set<String> set;
	
	//ayush
	// 1. WRONG.....storing ref to public variable
	void initialilize() {
		set = new HashSet<>();
	}
	
	private String[] states = new String[] {"A","B","C"};
	//2. returning the object....so any1 can change it
	String[] getStates() {
		return states;
	}
	
	//3. publish to methods ..which we be overridden...so we don't know, what will happen to our object
	final void method1(){
		method2(set);
	}
	
	void method2(Set<String> set) {
		//do anything
		//subclass can override this and do anything with this set
	}
	
	
	
	
	//4, publishing an inner class instance
	//inner classes store hidden ref to enclosing instance
	Publishing(EventSource source){
		new Thread() {
			public void run() {
				
			}
		}.start(); ///Absolutely NO
		
		
		
		//5. here we are registering event listener in the constructor through inner class
		//which means we are escaping our object b4 construction
		source.register(new EventListener() {
			public void onEvent() {
				//code
			}
		});
	}
	
	
	class EventSource{
		void register(EventListener eventListener){
			//code 
		}
	}


}

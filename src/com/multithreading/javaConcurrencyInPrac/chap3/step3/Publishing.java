package com.multithreading.javaConcurrencyInPrac.chap3.step3;

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
	
	//4, publishing an inner class instance
	//inner classes store hidden ref to enclosing instance
	Publishing(){
		new Thread() {
			public void run() {
				
			}
		}.start(); ///Absolutely NO
	}
	

}

package com.multithreading.javaConcurrencyInPrac.chap3.step4;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class StackConfinement {
	
	//use variables local to a method...
	//primitive local variables are always stack confined
	
	
	//still.....programmer has to amke sure that stack confined variables DON'T escape

	class MyObject {
		
	}
	void myMethod(Collection<MyObject> myObjects) {
		Set<MyObject> set;
		int count = 0;
		
		set = new HashSet<>();
		set.addAll(myObjects);
		count = set.size();
		
		//if below..then we are escaping it...so no thread safety
		///myMEthod2(set)
		
	}
	
}

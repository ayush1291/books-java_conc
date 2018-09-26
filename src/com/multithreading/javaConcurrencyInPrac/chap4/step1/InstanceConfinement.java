package com.multithreading.javaConcurrencyInPrac.chap4.step1;

import java.util.HashSet;
import java.util.Set;


//encapsulated,
public class InstanceConfinement {

	private final Set<MyObject> set = new HashSet<>();
	
	public synchronized void addtoSet(MyObject myObject){
		set.add(myObject);
	}
	
	public synchronized boolean isPresent(MyObject myObject){
		return set.contains(myObject);
	}
	
	
	class MyObject{
		//may or may not be thread safe....
		//but since our main object is encapsulated, we can work with this with/without additional sync..as per requirements
	}
}

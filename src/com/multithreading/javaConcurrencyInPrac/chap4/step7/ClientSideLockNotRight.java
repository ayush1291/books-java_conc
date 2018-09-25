package com.multithreading.javaConcurrencyInPrac.chap4.step7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClientSideLockNotRight {

	public List<String> list = Collections.synchronizedList(new ArrayList<>());
	
	//incorrect lock, the state of list should be guarded by its own lock
	public synchronized boolean putIfAbsent(String a){
		boolean absent = !list.contains(a);
		if(absent)
			list.add(a);
		return absent;
	}
}

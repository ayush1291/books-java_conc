package com.multithreading.javaConcurrencyInPrac.chap4.step7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClientSideLockRight {

	public List<String> list = Collections.synchronizedList(new ArrayList<>());
	
	public boolean putIfAbsent(String a){
		synchronized (list){
			boolean absent = !list.contains(a);
			if(absent)
				list.add(a);
			return absent;
		}
	}
}

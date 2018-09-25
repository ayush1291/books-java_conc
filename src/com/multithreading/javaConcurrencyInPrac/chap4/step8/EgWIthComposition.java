package com.multithreading.javaConcurrencyInPrac.chap4.step8;

//ayush 74
import java.util.List;

public class EgWIthComposition {
	
	//composing???
	private List<String> list;

	EgWIthComposition(List<String> list) {
		this.list = list;
	}

	public synchronized boolean putIfAbsent(String a) {
		synchronized (list) {
			boolean absent = !list.contains(a);
			if (absent)
				list.add(a);
			return absent;
		}
	}
	
	//other methods
}

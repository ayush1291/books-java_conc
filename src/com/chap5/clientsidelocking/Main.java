package com.chap5.clientsidelocking;

import java.util.Vector;

//Compound actions using client side locking

//Alternate strategy is decorator pattern
public class Main {
	
	public static Object get(Vector list){
		synchronized (list) {
			int ind = list.size();
			return list.get(ind);
		}
	}

	public static void remove(Vector list){
		synchronized (list) {
			int ind = list.size();
			list.remove(ind);
		}
	}
	
	public static void iternate(Vector list){
		synchronized (list) {
			for(int i=0; i<list.size();i++){
				//doSth(list.get(i));
			}
		}
		
	}
	
	
	
}

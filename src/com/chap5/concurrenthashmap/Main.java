package com.chap5.concurrenthashmap;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

//Makes faster by lock striping
//No concurrent mod exception- this is not fail-fast but weakly consistent - the iterators

//Check hos this uses iterator - vs hash map iterator

//This shows this is wekly consisten
//Size method returns an approx - this to be checked
//In this iteration, it takes a base limit, and then process accordingly, debug the iterator advance method and see base limit is 16 and even though new records are inserted, there is no use


//Can also look at methods like put-if-absent
public class Main {
	
	public static void main(String[] args) {
		ConcurrentHashMap<Integer, Integer> con = new ConcurrentHashMap<>();
		con.put(1, 1);
		Iterator<Entry<Integer,Integer>> itr = con.entrySet().iterator();
		int i=8;
		con.put(2, 1);
		con.put(3, 1);
		con.put(4, 1);
		while(itr.hasNext()){
			Entry<Integer, Integer> entr= itr.next();
			System.out.println(entr.getKey()+" "+entr.getValue());
			con.put(i,i++);
		}
	}

}

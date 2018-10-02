package com.chap5.conModiException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

//Synchronized collections are not designed to be thread safe during iteration
//They fail fast- Done deliberately for performance
//2 strategies- locking or cloning


//We cannot look for size while iteration--self gyan
public class Main {
	
	public static void main(String[] args) {
		List<String> vals = Collections.synchronizedList(new ArrayList<String>());
		
		vals.add("abc");
		vals.add("abc1");
		vals.add("abc2");
		vals.add("abc3");
		int i=0;
		
		Iterator<String> iterator= vals.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
//			iterator.remove();
		}
		
		for(String val : vals){
			System.out.println(val);
			vals.remove(2);
		}
		
	}

}

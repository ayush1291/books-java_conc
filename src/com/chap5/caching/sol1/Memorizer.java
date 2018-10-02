package com.chap5.caching.sol1;

import java.util.HashMap;
import java.util.Map;
import com.chap5.caching.ComputableMain;

//One point here is that if parent is not synchronized, child can be and vice versa is also true

//In this design, the problem is it is not scalable, and performance is low

public class Memorizer extends ComputableMain{

	Map<Integer, Integer> mem= new HashMap();
	
	@Override
	public synchronized Integer compute(Integer s) {
		if(mem.containsKey(s)){
			System.out.println("Already found "+s);
			return mem.get(s);
		}
		int val= super.compute(s);
		mem.put(s, val);
		return val;
	}


}

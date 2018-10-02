package com.chap5.caching.sol2;

import java.util.HashMap;
import java.util.Map;

import com.chap5.caching.ComputableMain;

//Little better than last, but still not performance wise good, see the main class, when sleep is removed, what happens

//Here, other threads like if 2 is being computed , 1 doesnt have to wait for its computation to get completed 

//Another problem is all of the threads compute same values till the time any one thread has not computed the same, it would have been better if
// the computation of other threads was waited for 

public class Memorizer2 extends ComputableMain{
	
Map<Integer, Integer> mem= new HashMap();
	
	@Override
	public Integer compute(Integer s) {
	
		synchronized (this) {
			if(mem.containsKey(s)){
				System.out.println("Already found "+s);
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return mem.get(s);
			}
		}
		
		int val= super.compute(s);
		
		synchronized (this) {
			mem.put(s, val);
		}
		
		
		return val;
	}

}

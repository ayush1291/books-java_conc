package com.chap5.caching.sol3;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.chap5.caching.ComputableMain;

//Here, we start using concurrent map, so problem when bolk of threads come is removed, since now lock striping is being used, and no single lock is used for all the values

//But in starting, the problem remains that multiple threads are computing the same values
public class Memorizer3 extends ComputableMain {

	Map<Integer, Integer> mem = new ConcurrentHashMap<>();

	@Override
	public Integer compute(Integer s) {

		if (mem.containsKey(s)) {
			System.out.println("Already found " + s);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return mem.get(s);
		}

		int val = super.compute(s);

		mem.put(s, val);

		return val;
	}

}

package com.chap5.caching.sol4;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import com.chap5.caching.Computable;

//Using future to avoid re calculation of same values

//One issue is still there when too many threads come in the start, try this by removing thread.sleep in main class

//Here, double checing is done which reduces atleast some double calculations

//Finally, make use of atomic putifabsent

public class Memorizer4 implements  Computable<Integer, Integer> {

	Map<Integer, Future<Integer>> mem = new ConcurrentHashMap<>();
	Computable<Integer, Integer> com =null;

	public Memorizer4(Computable<Integer, Integer> com) {
		this.com=com;
	}
	
	@Override
	public Integer compute(Integer s) {
		
		if (mem.containsKey(s)) {
			System.out.println("Already found but may be waiting" + s);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			try {
				return mem.get(s).get();
			} catch (InterruptedException | ExecutionException e) {
			}
		}
		
		
		FutureTask<Integer> ft = new FutureTask<>(new Callable<Integer>() {
			
			@Override
			public Integer call() throws Exception {
				return com.compute(s);
			}
		});

		
		//This step needs to be atomic, so that only one thread is able to put
//		if(!mem.containsKey(s)){
//			mem.put(s, ft);
//			ft.run();
//		}

		if(mem.putIfAbsent(s,ft)==null){
			ft.run();
		}
		
		//Now returning values
		try {
			return mem.get(s).get();
		} catch (InterruptedException e) {
		} catch (ExecutionException e) {
		}
		
		return null;
	}

}

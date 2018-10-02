package com.chap5.caching;

public class ComputableMain implements Computable<Integer, Integer>{

	@Override
	public Integer compute(Integer s) {
		System.out.println("Computing a big task for val "+s);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Compute is complete for "+s);
		return 21;
	}

}

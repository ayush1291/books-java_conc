package com.multithreading.javaConcurrencyInPrac.chap2.step5;

import java.math.BigInteger;

public class BadiaWalaCoutingFactorizerWithCaching {
	private BigInteger lastNumber;
	private BigInteger[] lastFactors;
	private long hits;
	private long cacheHits;
	
	public synchronized long getHits() {
		return hits;
	}
	
	public void service() {
		//get number from req and assign
		 BigInteger i = new BigInteger("10"); //from req
		BigInteger[] factors = null;
		synchronized(this){
			++hits;
			if (i.equals(lastNumber)) {
				++cacheHits;
				factors = lastFactors.clone();
			}
		}
		if (factors ==null){
			
			//factors = //compute factors
			synchronized(this){
				lastNumber = i;
				lastFactors = factors;
			}
		}
		
		
	}
	
}

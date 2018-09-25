package com.multithreading.javaConcurrencyInPrac.chap3.step5;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class CachingFactorizer {

	//solution to com.multithreading.javaConcurrencyInPrac.chap2.step3.UnsafeCountingFactorizer
	//if made volatile...same problem exists..so we can use a immutable holder here
	
	
	private volatile OneValueCache oneValueCache = new OneValueCache(null, null);
	
	public void findFactors() {
		
		 BigInteger num = new BigInteger("3"); //fetchFromRequest();
        BigInteger[] factors = oneValueCache.getFactors(num);
		if (factors == null) {
			factors = new BigInteger[5]; //factor(num);
			oneValueCache = new OneValueCache(num, factors);
		}
	}
	
	class OneValueCache {
		private final BigInteger lastNum;
		private final BigInteger[] lastFactors;
		
		public OneValueCache(BigInteger i, BigInteger[] factors) {
			lastNum = i;
			lastFactors = Arrays.copyOf(factors, factors.length);
		}
		
		public BigInteger[] getFactors(BigInteger i){
			if (lastNum == null || !lastNum.equals(i)){
				return null;
			} else{
				return Arrays.copyOf(lastFactors, lastFactors.length);
			}
		}
		
	}
	
}



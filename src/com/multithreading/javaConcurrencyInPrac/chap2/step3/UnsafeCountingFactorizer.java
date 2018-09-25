package com.multithreading.javaConcurrencyInPrac.chap2.step3;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;


//this is NOT thread safe...as the process of checking if its present in ref and actually getting it is NOT
//under same lock
//possible that the two operations of checking/fetching or calculations/setting may be INCORRECT (race condition)
public class UnsafeCountingFactorizer {

	private AtomicReference<BigInteger> lastNum = new AtomicReference();
	private AtomicReference<BigInteger[]> lastFactors = new AtomicReference();
	
	public void findFactors() {
		
		// BigInteger num = fetchFromRequest();
//		
//		if (num.equals(lastNum.get())) {
//			lastFactors.get();
//		} else {
//			//BigInteger[] factors = factor(num);
//			lastFactors.set(factors);
//		}
	}
	
}



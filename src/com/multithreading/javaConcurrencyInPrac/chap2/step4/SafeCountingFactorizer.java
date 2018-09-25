package com.multithreading.javaConcurrencyInPrac.chap2.step4;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

//since the whole process is governed by same lock....we wont see race conditions / incorrect o/p
public class SafeCountingFactorizer {

	private AtomicReference<BigInteger> lastNum = new AtomicReference();
	private AtomicReference<BigInteger[]> lastFactors = new AtomicReference();
	
	public synchronized void findFactors() {
		
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



package com.multithreading.javaConcurrencyInPrac.chap2.step2;


import java.util.concurrent.atomic.AtomicLong;

// since its atomic...we will never loose an update
public class SafeCountingFactorizer {

	private AtomicLong count = new AtomicLong(0);
	
	public void findFactors() {
		// BigInteger num = fetchFromRequest();
		//BigInteger[] factors = factor(num);
		count.incrementAndGet();
	}
	
}



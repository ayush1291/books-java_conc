package com.multithreading.javaConcurrencyInPrac.chap2.step1;

//++count may result in LOST updates, since this is NOT an atomic operation
//i.e. say Thread 1 sees value as 2 and increments it....But b4 assigning new value, new thread comes and
//writes value 3...so we can loose this value 3, when thread 1 comes and assigns value
public class UnsafeCountingFactorizer {

	private long count = 0;
	
	public void findFactors() {
		// BigInteger num = fetchFromRequest();
		//BigInteger[] factors = factor(num);
		++count;
	}
	
}






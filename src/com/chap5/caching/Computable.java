package com.chap5.caching;

public interface Computable<S,V> {
	
	public V compute(S s);

}

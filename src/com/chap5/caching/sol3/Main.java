package com.chap5.caching.sol3;

import com.chap5.caching.ComputableMain;


public class Main {
	static int i=0;
	
	public static void main(String[] args) {
		ComputableMain main = new Memorizer3();
		
		for(; i<100; i++){
			new Thread(){
				public void run() {
					if(i%3==0)
						main.compute(3);
					if(i%2==0)
						main.compute(1);
					else
						main.compute(2);
				};
			}.start();
			
			if(i<10)
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}

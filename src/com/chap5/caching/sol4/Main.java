package com.chap5.caching.sol4;

import com.chap5.caching.Computable;
import com.chap5.caching.ComputableMain;


public class Main {
	static int i=0;
	
	public static void main(String[] args) {
		Computable<Integer, Integer> main = new Memorizer4(new ComputableMain());
		
		
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
			
//			if(i<10)
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
		
	}
	
}

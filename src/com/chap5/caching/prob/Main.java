package com.chap5.caching.prob;

import com.chap5.caching.ComputableMain;

//Here, we see we are computing the long task for same values again and again, thus we need caching

public class Main {
	static int i=0;
	
	public static void main(String[] args) {
		ComputableMain main = new ComputableMain();
		
		for(; i<10; i++){
			new Thread(){
				public void run() {
					if(i%2==0)
						main.compute(1);
					else
						main.compute(2);
				};
			}.start();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}

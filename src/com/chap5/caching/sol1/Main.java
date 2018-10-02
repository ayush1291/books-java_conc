package com.chap5.caching.sol1;

import com.chap5.caching.ComputableMain;

//See the condition when 2 is not computed and threads which want to fetch value for 1 are also waiting becz of it

public class Main {
	static int i=0;
	
	public static void main(String[] args) {
		ComputableMain main = new Memorizer();
		
		for(; i<10; i++){
			new Thread(){
				public void run() {
					if(i%2==0)
						main.compute(1);
					else
						main.compute(2);
				};
			}.start();
		}
		
	}
	
}

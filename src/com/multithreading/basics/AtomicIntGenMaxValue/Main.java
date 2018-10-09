package com.multithreading.basics.AtomicIntGenMaxValue;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntUnaryOperator;

public class Main {
	
	AtomicInteger at = new AtomicInteger(0);
	
	
	public static void main(String[] args) {
		Main ma = new Main();
		
		for(int i=0; i<100; i++){
			
			new Thread(){
				public void run() {
					Random ran = new Random();
					final int gen = ran.nextInt(99);
					System.out.println("Gen "+gen);
					ma.at.updateAndGet(new IntUnaryOperator() {
						@Override
						public int applyAsInt(int operand) {
							return operand<gen?gen:operand;
						}
					});
				};
			}.start();
			
//			while(true){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Got   "+ma.at.get());
//			}
		}
		
		
	}
	
	
	
	
	

}

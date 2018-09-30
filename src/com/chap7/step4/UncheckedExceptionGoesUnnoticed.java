package com.chap7.step4;

import java.util.Timer;


//here, if an unhandled exception / runtime exception is thrown before interruption...it goes unnoticed
//if we comment out runtime exception. it will work as expcted


public class UncheckedExceptionGoesUnnoticed {

	public static void main(String[] args) {
		Thread a = new Thread(){
			
			private Throwable t;
			
			public void run() {
				
				System.out.println("A");
				try {
					int i =0;
					while(true){
						i++;
						if (i == 500){
							System.out.println("Throw exception from thread");
							t = new NullPointerException();
							throw new RuntimeException();
						}else{
							Thread.sleep(1);
						}
					}
					
				} catch (InterruptedException e) {
					System.out.println("Interruption handled");
				}
				
			};
		};
		
		a.start();
		
		try {
			Thread.sleep(3000);
	        System.out.println("State of thread a : " + a.getState().name());
			System.out.println("Interrupt A");
			a.interrupt();
		} catch (InterruptedException e) {
			System.out.println("InterruptedException caught");
			e.printStackTrace();
		}
		 catch (Exception e) {
			 System.out.println("Exception caught");
				e.printStackTrace();
			}
		
	}
	
}

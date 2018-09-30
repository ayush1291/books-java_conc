package com.chap7.step4;

import java.util.Timer;


//sol1 : rethrow the error / check if error was thrown post completion
public class UncheckedExceptionGoesUnnoticedSoln1 {

	public static void main(String[] args) {
		A a = new A();
		a.start();
		
		try {
			Thread.sleep(3000);
	        System.out.println("State of thread a : " + a.getState().name());
			System.out.println("Interrupt A");
			a.interrupt();
			a.rethrow();
		} catch (InterruptedException e) {
			System.out.println("InterruptedException caught");
			e.printStackTrace();
		}
		 catch (Exception e) {
			 System.out.println("Exception caught");
				e.printStackTrace();
		}
		
	}
	
	static class A extends Thread {
		private volatile Exception t;
		
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
			
		}
		
		public void rethrow() throws Exception{
			if (t != null)
				throw t;
		}
	}
	
}

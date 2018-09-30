package com.chap7;

public class InterruptionBasic {
	
	
	
	
	//Threre is a problem in this approach when using blocking queue, as if put is called, no use of cancel
	
	
	
	
	
	
	public static void main(String[] args) throws InterruptedException {
		PrimeGen gen = new PrimeGen();
		new Thread(gen).start();
		
		Thread.sleep(1000);
		gen.cance();
		
	}
	

	static class PrimeGen implements Runnable {

		volatile boolean isCanceled;
		volatile int number = 1;

		@Override
		public void run() {

			while (!isCanceled) {
				System.out.println("Next prime is generated " + number++);
			}

		}
		public void cance(){
			System.out.println(number +" while cancel ");
			isCanceled=true;}
	}
	
	

}

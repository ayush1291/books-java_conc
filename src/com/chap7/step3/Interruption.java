package com.chap7.step3;

import java.util.concurrent.Executors;

//pg. 144
public class Interruption {

	public static void main(String[] args) {
		
		
		//check awai for info
		Thread a = new Thread();
		//interrupts and sets the flag
		a.interrupt();
		//resets the flag
		a.isInterrupted();
		
		
		NonCancelableTask nonCancelableTask = new NonCancelableTask();
		try {
			nonCancelableTask.start();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			nonCancelableTask.interrupt();
			
			//Race condition here - 
			if (nonCancelableTask.isInterrupted()) {
				System.out.println("AAAAA");
				throw new RuntimeException();
			}
			System.out.println("eeeeee");
		} catch (Exception e){
			e.printStackTrace();
		}
		
		
		
		
	}
	
	static class NonCancelableTask extends Thread{
		
		@Override
		public void run() {
			
				try{
					while(true) {
						try {	
							System.out.println("yo yo ayush");
							Thread.sleep(1000);
						}catch (Exception e){
							if (e instanceof InterruptedException) {
								System.out.println("InterruptedException ****");
								break;
							}	
						}	
					}
				}finally{
					//if(Thread.currentThread().isInterrupted()){
					System.out.println("###########" + Thread.currentThread().isInterrupted());
						Thread.currentThread().interrupt();
					//}
				}
		}
		
	}
	
}

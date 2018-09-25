package com.multithreading.basics;


public class TestInterruptExceptionPropagation {
public static void main(String[] args) {
		
		Thread t = new Thread(new MyRunnable());
		t.start();
		
		try {
			Thread.sleep(1);
			t.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			System.out.println("InterruptedException of prev thread caught");
		}
		
		System.out.println("Main continues");
		
		
		
	}
	
	public static class MyRunnable implements Runnable{
		
		@Override
		//public void run() throws Exception{ : public void run() throws Exception{
		public void run() {
			int i=0;
			while(i<10){
				try {
					System.out.println(i);
					i++;
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					/// NOT allowed as we  will have to handle this
					/// throw new Exception
					throw new RuntimeException(); 
				}
				
				
			}
			
		}
		
	}
}

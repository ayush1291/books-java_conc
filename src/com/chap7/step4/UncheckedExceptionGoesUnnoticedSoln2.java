package com.chap7.step4;

import java.util.Timer;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


//sol2 : use execution service submit method
// it returns future
//whose gte() method wraps the exceptiopn occurred as ExecutionException
public class UncheckedExceptionGoesUnnoticedSoln2 {

	public static void main(String[] args) {
		A a = new A();
		ExecutorService exe = Executors.newSingleThreadExecutor();
		//cheeck submit implemtation
		Future<?> future = exe.submit(a);
		try {
			future.get(1000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException | ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static class A extends Thread {
		
		public void run() {
			System.out.println("A");
			try {
				int i =0;
				while(true){
					i++;
					if (i == 500){
						System.out.println("Throw exception from thread");
						throw new RuntimeException();
					}else{
						Thread.sleep(1);
					}
				}
				
			} catch (InterruptedException e) {
				System.out.println("Interruption handled");
			}
			
		}

	}
	
}

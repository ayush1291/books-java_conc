package com.chap6;

public class ThreadOverheadError {
	
	public static void main(String[] args) {
		while(true){
			new Thread(){
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName());
					try {
						Thread.sleep(100000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}.start();
		}
		
	}

}

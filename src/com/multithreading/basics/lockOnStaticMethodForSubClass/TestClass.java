package com.multithreading.basics.lockOnStaticMethodForSubClass;

public class TestClass {
	public static void main(String[] args) {
	  Child child = new Child();
	  new Thread(){
		  @Override
		  public void run() {
			  child.printMessage();
		}
	  }.start();;
	  	  
	  try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  System.out.print("Checking the other one");
	  Parent parent = new Parent();
	  parent.printMessage();
	}
}

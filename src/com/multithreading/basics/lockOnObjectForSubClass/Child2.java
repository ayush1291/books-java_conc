package com.multithreading.basics.lockOnObjectForSubClass;

public class Child2 {
	
	public synchronized void printM(){
		Parent p = new Parent();
		p.printMessage();
	}

}

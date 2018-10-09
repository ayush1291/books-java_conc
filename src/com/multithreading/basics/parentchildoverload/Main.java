package com.multithreading.basics.parentchildoverload;

public class Main {

	
	public static void main(String[] args) {
		
		Parent p = new Child();
		Main m = new Main();
		m.doS(p);
		
	}
	
	
	public void doS(Parent p){
		System.out.println("Do1");
	}
	
	public void doS(Child p){
		System.out.println("Do2");
	}
	
	static class Parent{
		
	}

	static class Child extends Parent{
		
	}
}

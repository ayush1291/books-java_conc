package com.multithreading.basics.exception_propagate;

import java.io.FileNotFoundException;

public class Main {
	
	public static void main(String[] args) {
		
		
	}
	
	
	abstract class Test{
		abstract void do1();
		
		void do2(){
			System.out.println("DO2");
		}
		
		void do3() throws Exception{
			System.out.println("DO2");
		}
	}
	
	class Main2 extends Test{
		@Override
		void do1() //throws Exception
		{
			
		}
		
		@Override
		void do2()//  throws Exception
		{
			super.do2();
		}
		
		@Override
		void do3() throws FileNotFoundException {
		}
	}

}

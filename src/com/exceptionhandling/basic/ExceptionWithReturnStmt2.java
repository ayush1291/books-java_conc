package com.exceptionhandling.basic;

public class ExceptionWithReturnStmt2 {
	
	
	public static void main (String[] args) {
		
		try {
			int a= 10/0;
		}
		catch(ArithmeticException e){
			System.exit(0);

			System.out.println(e.getMessage() +"---------" +  e);
		}finally{
			System.out.println("finally");
		}
		
	}
}

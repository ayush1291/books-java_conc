package com.exceptionhandling.basic;

public class ExceptionWithReturnStmt3 {
	
	
	public static void main (String[] args) {
		
		try {
			int a= 10/0;
		}
		catch(ArithmeticException e){
			System.out.println(e.getMessage() +"---------" +  e);
			System.exit(0);
		}finally{
			System.out.println("finally");
		}
		
	}
}

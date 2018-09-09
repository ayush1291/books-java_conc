package com.exceptionhandling.basic;

public class ExceptionWithReturnStmt1 {
	
	
	public static void main (String[] args) {
		
		try {
			int a= 10/0;
			return;
		}
		catch(ArithmeticException e){
			System.out.println(e.getMessage() +"---------" +  e);
			return;
		}finally{
			System.out.println("finally");
			return;
		}
		
	}
}

package com.exceptionhandling.custom;

public class TestClass {

	
	public static void main(String[] args){
		
		try{
			callMethodThrowingException();
		}
		catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
		}
	}

	//uncomment to see that since it doesn't extend RunTime Exception. it will be treated as a checked exception
//	private static void callMethodThrowingException() {
//		
//		throw new CustomException();
//		
//	}
	
	private static void callMethodThrowingException() throws CustomException{
		throw new CustomException();
	}
}

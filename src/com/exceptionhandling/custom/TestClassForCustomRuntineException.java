package com.exceptionhandling.custom;

public class TestClassForCustomRuntineException {

	
	public static void main(String[] args){
		
		callMethodThrowingException();
	}

	
	
	//note that, compiler doesn't force to add throws clause, or wrap around try/catch
	private static void callMethodThrowingException(){
		throw new CustomRuntimeException();
	}
}

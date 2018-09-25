package com.exceptionhandling.inheritance;

import java.io.FileNotFoundException;

public class Parent {

	
	void methodWithNoException (){

	}
	
	void methodWithParentException() throws Exception {
		
	}
	
	void methodWithChildException() throws FileNotFoundException {
		
	}
	
	void methodWithMultipleException() throws FileNotFoundException, InterruptedException {
		
	}
}


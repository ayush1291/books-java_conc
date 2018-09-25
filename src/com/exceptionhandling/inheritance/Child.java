package com.exceptionhandling.inheritance;

import java.io.EOFException;
import java.io.FileNotFoundException;

public class Child extends Parent{

	
	//NOT allowed as Parent does NOT throw exception
//	@Override
//	void methodWithNoException() throws Exception{
//		// TODO Auto-generated method stub
//	}
	
	//Allowed
//	void methodWithParentException() throws Exception {
//		
//	}
	
	//Allowed to reduce the scope
	void methodWithParentException() throws FileNotFoundException {
		
	}
	
	//Allowed to NOT throw any exception
//	void methodWithChildException() {
//		
//	}
	
	//NOT allowed as SCope increased
//	void methodWithChildException() throws IOException {
//		
//	}

//	void methodWithMultipleException() throws  InterruptedException {
//		
//	}
	
	//same family not allowed, only sub classes allowed
//void methodWithMultipleException() throws  EOFException {
//		
//	}

}

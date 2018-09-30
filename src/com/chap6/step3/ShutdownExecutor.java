package com.chap6.step3;

import java.util.concurrent.ExecutorService;

public class ShutdownExecutor {

	//extends executor and provides method for shutting down the executor (i.e. manage its life cycle)
	ExecutorService executorService;
	//check its methods
	
	//there are 3 states of executor: running, shutting down, terminated
	//there are 3 states of task: created, submitted, started, completed

	//shutdown() : no new methods accepted, but previously submitted are completed
	//shutdownnow() : no new methods accepted, previously submitted but NOt started are not started, running are cancelled 
	
	
	
	
}

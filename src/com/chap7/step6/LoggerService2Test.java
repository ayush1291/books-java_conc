package com.chap7.step6;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;



public class LoggerService2Test {

	public static void main(String[] args) throws InterruptedException {
		LoggerService2 logger = new LoggerService2();
		logger.start();
		for(int i=0; i<30; i++){
			if(i==15)
				logger.stop();
			logger.put(i+"");
		}		
	}
	
}

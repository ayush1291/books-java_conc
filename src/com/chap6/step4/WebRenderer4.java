package com.chap6.step4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

///using completion service
//i.e. get data as and when u get
public class WebRenderer4 {

	//Heterogeneous tasks are executed in parallel
	void render(){
		
		CompletionService completionService = new ExecutorCompletionService(Executors.newFixedThreadPool(1210));
		List<String> images = new ArrayList(); //get list of images
		for (String image : images) {
			Callable<String> task = new Callable<String>() {
				@Override
				public String call() throws Exception {
					//start download and return result
					return "downloadedIamge";
				}
			};	
			
			 completionService.submit(task);
		}
		
		
		
		//rendertext
		
		for (String image : images) {
			try {
				Future<String> result = completionService.take();
				//renderImage
				try {
					result.get(2, TimeUnit.SECONDS);
				} catch (ExecutionException | TimeoutException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

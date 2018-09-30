package com.chap6.step4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.*;

////here we are still downloading all at once
public class WebRenderer2 {

	//Heterogeneous tasks are executed in parallel
	void render(){
		
		ExecutorService executorService = Executors.newFixedThreadPool(1210);
		List<String> iamgeNames = new ArrayList(); //get list of images
		Callable<List<String>> task = new Callable<List<String>>(
				) {

					@Override
					public List<String> call() throws Exception {
						//start download and return result
						return new ArrayList();
					}
		};
		
		Future<List<String>> downloadedImages = executorService.submit(task);
		//rendertext
		try{
			//renderImagesByFetching
			downloadedImages.get();
		}catch (InterruptedException | ExecutionException e){
			downloadedImages.cancel(true);
		}
	}
}

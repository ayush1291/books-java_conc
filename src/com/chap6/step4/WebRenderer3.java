package com.chap6.step4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

//i.e. get data as and when u get
public class WebRenderer3 {

	//Heterogeneous tasks are executed in parallel
	void render(){
		
		ExecutorService executorService = Executors.newFixedThreadPool(1210);
		List<Callable<String>> tasks = new ArrayList(); 
		
		
		for(int i=0; i<10; i++){
			tasks.add(new Callable<String>() {
						@Override
						public String call() throws Exception {
							//start download and return result
							return "downloadedImag";
						}
			});
		}
		
		//rendertext
		List<Future<String>> downloadedImages;
		try {
			downloadedImages = executorService.invokeAll(tasks);
			for(Future<String> downloadedImage : downloadedImages){
				try {
					downloadedImage.get();
				} catch (InterruptedException | ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}			
		
	}
}

package com.multithreading.javaConcurrencyInPrac.chap3.step4;

//ayush : cahing se faster h??? pg 46
public class ThreadLocalEg {

	
	//to convert your single threaded application to multithreaded one, u can convert global shared variables to ThreadLocals
	
	//ThreadLocal<T> ==> Map<Thread, T>
	//Thread specific values are stored in thread itself...when thread dies...they are eligible for garbage collection
	
	 private static final ThreadLocal<String> EVT_REG_TYPE_ID = new ThreadLocal<String>() {
	        @Override
	        public String initialValue() {
	            return "0"; // setting initial value for reg type id = 0
	        }
	    };
	    
	    
	    public static String getEvtRegTypeId() {
	        return EVT_REG_TYPE_ID.get();
	    }

	    public static void setEvtRegTypeId(String evtRegTypeId) {
	        EVT_REG_TYPE_ID.set(evtRegTypeId);
	    }

	    public static void removeRegTypeId() {
	        EVT_REG_TYPE_ID.remove();
	    }
	
}

package com.multithreading.javaConcurrencyInPrac.chap4.step3;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


//even though MjtablePOint is not thread safe...we won't face a problem as while returning we r returning a new point
// or we return a unmodifiable map

//problems : 1. the map returned is an old copy, so if content changes, its not reflected
//2. always copying whenever returning
public class Tracker {

	private Map<String, MutablePoint> locations;
	
	Tracker(Map<String, MutablePoint> locations) {
		this.locations = deepCopy(locations);
	}
	
	public synchronized Map<String, MutablePoint> getLocations() {
		return deepCopy(locations);
	}
	
	public synchronized MutablePoint getLocations(String id) {
		MutablePoint point =  locations.get(id);
		return point == null ? null : new MutablePoint(point);
	}
	
	public synchronized void setLocations(String id, int x, int y) throws Exception {
		MutablePoint point =  locations.get(id);
		if(point == null)
			throw new Exception();
		point.x = x;
		point.y = y;
	}
	
	private static Map<String, MutablePoint> deepCopy(Map<String, MutablePoint> map){
		Map<String, MutablePoint> result = new HashMap();
		for (String id : map.keySet()) {
			result.put(id, new MutablePoint(map.get(id)));
		}
		//interesting....
		return Collections.unmodifiableMap(result);
	}
	
}

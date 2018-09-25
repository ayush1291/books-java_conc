package com.multithreading.javaConcurrencyInPrac.chap4.step6;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

//returns unmodifiable.....BUT live view of map
//callers cannot modify the map..but its content can  be modified
public class Tracker {

	private final ConcurrentMap<String, MutablePoint> locations;
	private final Map<String, MutablePoint> unmodifiableMap;
	
	Tracker(Map<String, MutablePoint> points) {
		locations = new ConcurrentHashMap<>(points);
		unmodifiableMap = Collections.unmodifiableMap(locations);
	}
	public Map<String, MutablePoint> getLocations() {
		return unmodifiableMap;
	}
	
	public MutablePoint getLocations(String id) {
		return locations.get(id);
	}
	
	public void setLocations(String id, int x, int y) throws Exception {
		if(locations.replace(id, new MutablePoint(x, y)) == null) {
			throw new Exception();
		}
	}
	
}

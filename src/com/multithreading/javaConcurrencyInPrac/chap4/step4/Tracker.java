package com.multithreading.javaConcurrencyInPrac.chap4.step4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

//returns unmodifiable.....BUT live view of map
//also, since its immutable..publishing it is not a problem
public class Tracker {

	private final ConcurrentMap<String, ImmutablePoint> locations;
	private final Map<String, ImmutablePoint> unmodifiableMap;
	
	Tracker(Map<String, ImmutablePoint> points) {
		locations = new ConcurrentHashMap<>(points);
		unmodifiableMap = Collections.unmodifiableMap(locations);
	}
	public Map<String, ImmutablePoint> getLocations() {
		return unmodifiableMap;
		//if we want to return "old" view
		//return  Collections.unmodifiableMap(new HashMap<>(locations));
	}
	
	public ImmutablePoint getLocations(String id) {
		return locations.get(id);
	}
	
	public void setLocations(String id, int x, int y) throws Exception {
		if(locations.replace(id, new ImmutablePoint(x, y)) == null) {
			throw new Exception();
		}
	}
	
}

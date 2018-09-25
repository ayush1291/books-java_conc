package com.multithreading.javaConcurrencyInPrac.chap3.step4;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ImmutableClass {

	private final int intVariable;
	private String stringVariable;
	private Set<MyObject> set;
	
	ImmutableClass() {
		intVariable = 12101991;
		stringVariable = "Ayush";
		set = new HashSet<>();
		set.add(new MyObject(Arrays.asList("Cooking","Dancing","kickBoxing"), Arrays.asList("AshKumar", "yush")));
	}
	
	public int getIntVariable() {
		return intVariable;
	}

	public String getStringVariable() {
		return stringVariable;
	}

	public Set<MyObject> getSet() {
		return set;
	}

	
	
	
	class MyObject {
		final String[] hobbies;
		final String[] nickNames;
		
		MyObject(List<String> hobbies, List<String> nickNames) {
			this.hobbies = (String[]) hobbies.toArray();
			this.nickNames = (String[]) nickNames.toArray(); 
		}
	}
	
	
	
}

package com.test.demo;

import java.io.Serializable;

public class Singleton implements Serializable {
	
	
	public static Singleton single_ton = null;
	String s = null;
	private Singleton() {
		s = "singleton class";
	}
	
	public static Singleton singleton() {
		if(single_ton == null) {
			single_ton = new Singleton();
		}
		
		return single_ton;
	}
	
	protected Object readResolve() {
		return single_ton;
	}

	

}

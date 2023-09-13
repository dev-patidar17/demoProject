package com.test.demo;

@FunctionalInterface
public abstract interface TempInterface {
	
	public int adding(int a, int b);
	
	
	public default int sub() {
		return 0;
		
	}
	public default int su1b() {
		return 0;
		
	}
}

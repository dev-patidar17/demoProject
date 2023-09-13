package com.test.demo;

import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryError {
	
	public String method() {
		List<String> sList = new ArrayList<>(); 
		while(true) {
			String s = new String("Hello Word");
			sList.add(s);
		}
		
	}
	
	public static void main(String[] args) {
		OutOfMemoryError out = new OutOfMemoryError();
		out.method();
	}

}

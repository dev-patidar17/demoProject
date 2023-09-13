package com.test.demo;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashMapExp {
	
	public void hashMapOperation() {
		Map<String, Integer> map = new HashMap<>();
		
		Integer put = map.put("A", 1);
		put = map.put("B", 2);
		put = map.put("B", 7);
		put = map.put(null, null);
		System.out.println(put); 
		
		Hashtable<String, String>  hashTab = new Hashtable<>();
		String put2 = hashTab.put(null, "fdf");
		hashTab.put("H", null);
		
	}

	public static void main(String[] args) {
		
		HashMapExp ex =new HashMapExp();
		ex.hashMapOperation();
		
	}
}

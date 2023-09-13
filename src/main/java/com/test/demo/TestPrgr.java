package com.test.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestPrgr {

	public static void main(String[] args) {
		
		List<String> nameList = Arrays.asList("Dev","Dev","Arun","Arun","Arun");
		Set<String> nameSet = new HashSet<>();
		Map<String,Integer> duplicate = new HashMap<>();
		
		Map<String, Long> collect = nameList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		
		for (String name : nameList) {
			
			if(nameSet.contains(name)) {
				
				if(duplicate.containsKey(name)) {
					Integer integer = duplicate.get(name);
						duplicate.put(name,integer+1);
				}
				
			}else {
				nameSet.add(name);
				duplicate.put(name,0);
			}
			
		}
		
		duplicate.forEach((k,v)->{
			System.out.println(k+" "+v); 
		});
		

	}

}

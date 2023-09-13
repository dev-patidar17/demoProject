package com.test.demo;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestDuplist {

	public static void main(String[] args) {
		
		
		List<String> dupList = Arrays.asList("Morning","Evening","Noon","Morning");
		
		List<String> uniqueList = dupList.stream().distinct().collect(Collectors.toList());
		
		uniqueList.forEach(System.out::print);
		

	}

}

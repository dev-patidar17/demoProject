package com.test.demo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestDemo {

	public static void main(String[] args) {
	
		
		 LocalDate date = LocalDate.now();
	      int year = date.getYear();
	      int month = date.getMonthValue();
	      int financialYear = year;
	      
	      if (month >= 4) {
	         financialYear++;
	      }
	      
	      System.out.println("Financial year: " + financialYear);

	}

}

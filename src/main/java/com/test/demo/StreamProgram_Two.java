package com.test.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamProgram_Two {
	
	
	
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
		
		List<Employee> empList = Arrays.asList(new Employee(1, "Zolly", 10000, sm.parse("2022-01-01")),
				new Employee(2, "Dev", 10000, sm.parse("2022-01-02")),
				new Employee(2, "Dev", 12000, sm.parse("2022-01-02")),
				new Employee(2, "Heer", 11000, sm.parse("2022-01-02")));
		
		
		Map<String, Long> collect = empList.stream().collect(Collectors.groupingBy(Employee::getName,Collectors.counting()));
		Map<String, List<Employee>> collect2 = empList.stream().collect(Collectors.groupingBy(Employee::getName));
		Double collect3 = empList.stream().collect(Collectors.averagingDouble(obj -> obj.getSalary()));
		Employee orElse2 = empList.stream().collect(Collectors.maxBy((obj1,obj2)-> Double.compare(obj1.getSalary(), obj2.getSalary()))).orElse(null);
		List<String> srtLis = Arrays.asList("Hello","Hi");
		String orElse = srtLis.stream().reduce((obj1,obj2)-> obj1+"_"+obj2).orElse("Not Found");
		System.out.println(orElse);
		
		Function<Employee, String> fun1 = Employee::getName;
		Function<Employee, Double> fun2 =Employee::getSalary;
		
		Comparator<Employee> compa = Comparator.comparing(fun1).thenComparing(fun2);
		List<Employee> collect4 = empList.stream().sorted(compa).collect(Collectors.toList());
		List<String> collect5 = srtLis.stream().sorted((o1,o2)-> o1.compareTo(o2)).collect(Collectors.toList());
		
		
		TreeMap<String, String> tMap = new TreeMap
		
		
		
	}

}

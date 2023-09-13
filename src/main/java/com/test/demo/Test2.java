package com.test.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test2 {
	
	public static SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		List<Product> prodArray = Arrays.asList(new Product(0, "Book1", "Com", 10.5),new Product(1, "Book2", "Com", 15.5),new Product(3, "Book3", "Com", 5.5));
		//Customer cut = new Customer(1, "John", 1);
		//Order o = new Order(0, "pending", new Date(), new Date(), prodArray,cut);
		
		List<Product> collect = prodArray.stream().sorted((opb,obj1) -> Double.compare(opb.getPrice(), obj1.getPrice())).collect(Collectors.toList());
		
		
		System.out.println(collect.get(0).getId()+" "+collect.get(0).getPrice() );
		
		
		List<Employee> empList3 = Arrays.asList(new Employee(1, "Zolly","Pal", 10000, sm.parse("2019-01-01"),"IT"),
				new Employee(2, "Zolly","Pal", 10000, sm.parse("2019-01-01"),"IT"),
				new Employee(3, "Raj","kumar", 12000, sm.parse("2021-01-02"),"HR"),
				new Employee(4, "Ram","Krishna", 11000, sm.parse("2020-01-02"),"ADMIN"));
		
		List<Integer> intList = Arrays.asList(1,1,3,4,3,2,5,6,4);
		intList.stream().distinct().sorted((obj1,obj2) -> Integer.compare(obj2, obj1)).forEach(System.out::println);;
		
		Map<Integer, Employee> collectMap = empList3.stream().collect(Collectors.toMap(Employee::getId, Function.identity()));
		
		collectMap.forEach((k,v) -> {
			
			System.out.println(k + "  "+v);
			
		});
		
		
		boolean allMatch = empList3.stream().allMatch(obj -> obj.getName().startsWith("Z"));
		System.out.println(allMatch);
		
		empList3.stream().filter(obj -> obj.getLastName().startsWith("P")).forEach(System.out::println);
		
		Double collect2 = empList3.stream().collect(Collectors.averagingDouble(obj -> obj.getSalary()));
		
		boolean naN = empList3.stream().collect(Collectors.averagingDouble(obj -> obj.getSalary())).isNaN();
		System.out.println(collect2+"_"+naN);
		
		Map<Integer, List<Employee>> collect3 = empList3.stream().collect(Collectors.groupingBy(Employee::getId));
		
		Long collect4 = empList3.stream().collect(Collectors.counting());
		
		System.out.println(collect4);
		
		List<List<Employee>> listOfEmpList = new ArrayList<>();
		
		listOfEmpList.add(empList3);
		
		listOfEmpList.stream().flatMap(obj -> obj.stream()).forEach(System.out::println);
		
		List<String> listInt = Arrays.asList("1","2","3","6","43","76","54","564");
		
		 listInt.stream().flatMapToInt(obj -> IntStream.of(obj.length())).forEach(System.out::println); 
		
		List<List<Integer>> listOfIntList = new ArrayList<>();
		
		//.listOfIntList.add(listInt);
		
	//	listOfIntList.stream().flatMapToInt(obj -> obj.stream());
		
		
		
		
		
		
		
		
		
	}

}

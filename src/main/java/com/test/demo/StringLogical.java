package com.test.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import ch.qos.logback.core.net.SyslogOutputStream;

public class StringLogical {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
		Map<String, String> map = new HashMap<>();
		Map<String, String> synchronizedMap = Collections.synchronizedMap(map);

		String ss = "Ahmedabad";
		
		
		Map<Character, Integer> strOccurance = new HashMap<>();
		
		for(int i = 0; i< ss.length(); i++) {
			
			if(strOccurance.containsKey(ss.charAt(i))) {
				strOccurance.put(ss.charAt(i), Integer.valueOf(strOccurance.get(ss.charAt(i))+1));
			}else {
				strOccurance.put(ss.charAt(i),1);
			}
			
		}
		strOccurance.forEach((k,v)-> {
			System.out.println(k+" "+v);
		});
		
		List<String> strList = Arrays.asList("Bhaumik","Rita","Bhautik","Dev");
		
		Map<String, Long> collect = strList.stream().collect(Collectors.groupingBy(obj -> obj,Collectors.counting()));
		
		List<char[]> asList = Arrays.asList(ss.toCharArray());
		
		Map<char[], Long> collect2 = asList.stream().collect(Collectors.groupingBy(obj -> obj, Collectors.counting()));
		
		collect2.forEach((k,v)->{
			System.out.println(k+"..."+v);
		});
		
		
		List<Employee> empList = Arrays.asList(new Employee(1, "Aolly", 10000000, sm.parse("2022-01-01")),
				new Employee(2, "Dev", 100000, sm.parse("2022-01-02")),
				new Employee(3, "Dev", 12000, sm.parse("2022-01-02")),
				new Employee(4, "Heer", 11000, sm.parse("2022-01-02")));
		
		Function<Employee, String> empSortFirst = Employee::getName;
		Function<Employee, Double> empSortSec = Employee::getSalary;
		
		Comparator<Employee> com_one = Comparator.comparing(empSortFirst).thenComparing(empSortSec);
		empList.stream().sorted(com_one).forEach(obj -> {
			System.out.println(obj.getName()+"....."+obj.getSalary()); 
		});
		
		Map<Integer, Employee> collect3 = empList.stream().collect(Collectors.toMap(Employee::getId,Function.identity()));
		
		collect3.forEach((key,value)->{
			System.out.println(key+"....."+value); 
		});
		
		List<Employee> collect4 = empList.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
		empList.stream().sorted((obj1,obj2)-> Double.compare(obj2.getSalary(), obj1.getSalary()))
				.forEach(obj->{
					System.out.println(obj.getSalary());
				});
		
		BiFunction<String, String, Boolean> biFunExa = (x,y)-> x.contains(y);
		
		System.out.println(biFunExa.apply("Dev Patidar", "Patidarr"));
		
		empList.stream().filter(obj -> !obj.getName().startsWith("D")).forEach(ob -> System.out.println(ob.getName()));
		
		Consumer<String> strCunsumer = str -> System.out.println("Vehicle consume "+str);
		
		strCunsumer.accept("Petrol");
		
		Supplier<String> strSupplier = () -> ("UUID supplie by supplier is "+UUID.randomUUID().toString());
		
		System.out.println(strSupplier.get());
		
		Predicate<String> strPredicate = str-> !str.contains("Dev");
		
		empList.stream().filter(obj -> strPredicate.test(obj.getName())).forEach(obj -> {System.out.println(obj.getName());}); 
		
		Map<String, List<Employee>> collect5 = empList.stream().collect(Collectors.groupingBy(Employee::getName));
		Map<String, Long> collect6 = empList.stream().collect(Collectors.groupingBy(Employee::getName, Collectors.counting()));
		
		System.out.println(collect5);
		
		Function<Employee, String> name = Employee::getName;
		Function<Employee, Double> sal = Employee::getSalary;
		
		Comparator<Employee> comparator = Comparator.comparing(name).thenComparing(sal);
		
		
		List<Employee> collect7 = empList.stream().sorted(comparator).collect(Collectors.toList());
		
		List<Integer> intList = Arrays.asList(2,4,5,6);
		
		Double collect8 = intList.stream().collect(Collectors.averagingInt(obj -> obj));
		System.out.println(collect8);
		
		List<List<Employee>> empListList = new ArrayList<>();
		
		empListList.add(empList);
		
		Double collect9 = empListList.stream().flatMap(List::stream).collect(Collectors.averagingDouble(obj -> obj.getSalary()));
		System.out.println(collect9);
	}

}

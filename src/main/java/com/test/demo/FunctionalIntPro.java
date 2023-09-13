package com.test.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FunctionalIntPro{

	public static void main(String[] args) throws ParseException {
		
		Predicate<Integer> greaterThenFive = (i)-> i>5;
			
			
		Predicate<Integer> lessThen10 = (i)-> i<10;
		
		
		
		boolean test = greaterThenFive.and(lessThen10).test(8);
		
		
		System.out.println(test);
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
		List<Employee> empList = Arrays.asList(new Employee(1, "Zolly", 10000, sm.parse("2022-01-01")),
				new Employee(2, "Dev", 10000, sm.parse("2022-01-02")),
				new Employee(2, "Dev", 12000, sm.parse("2022-01-02")),
				new Employee(2, "Heer", 11000, sm.parse("2022-01-02")));
		
		Predicate<List<Employee>> empPrede = (emp) ->{
			
			List<Employee> collect = emp.stream().filter(x-> x.getName().equals("Nagin")).collect(Collectors.toList());
			
			return collect.isEmpty() ? false: true;
		};
		Predicate<List<Employee>> checkValue = (emp) -> {
			
			
			return false;
		};
		System.out.println(empPrede.negate().and(checkValue).test(empList));
		
		Employee emp22 = new Employee(1, "Zolly", 10000, sm.parse("2022-01-01"));
		
		System.out.println(emp22);
		System.out.println(emp22.toString());
		
		Function<List<Employee>, List<Employee>> empFun = (emp) ->  {
			
			List<Employee> collect = emp.stream().map(x-> {x.setName(x.getName()+"_Function"); return x;}).collect(Collectors.toList());
			return collect;
		};
		
		Function<List<Employee>, List<Employee>> empFun1 = (emp) -> {
			 List<Employee> collect = emp.stream().dropWhile(x -> x.getSalary() == 10000).collect(Collectors.toList());
			 
			 return collect;
		};
		List<Employee> apply = empFun.andThen(empFun1).apply(empList);
		System.out.println(apply);
		
		BiFunction<List<Employee>, String, List<Employee>> bifunctionList = (emp, str) -> {
			
			return emp.stream().map(x-> {x.setName(x.getName()+" "+str); return x;}).collect(Collectors.toList());
			
		};
		List<Employee> apply2 = bifunctionList.apply(empList, "Hello");
		
		apply2.stream().forEach(x-> System.out.println(x.toString()));
		
		Consumer<List<Employee>> empConsumer = (emp) -> {
			
			System.out.println("Using Consumer....!");
			emp.forEach(x-> System.out.println(x.toString()));
			
		};
		
		
		empConsumer.andThen(empConsumer).accept(empList); 
		
		Supplier<Employee> empSuppl = () -> {
			Employee em= null;
			try {
				em = new Employee(1, "Zolly", 10000, sm.parse("2022-01-01"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return em;
			
		};
		
		Employee employee = empSuppl.get();
		System.out.println("empSuppl..."+employee.toString());
		
		
		List<Employee> empList2 = Arrays.asList(new Employee(1, "Zolly","Pal", 10000, sm.parse("2022-01-01"),"IT"),
				new Employee(2, "Dev","xpatidar", 10000, sm.parse("2022-01-02"),"IT"),
				new Employee(2, "Dev","patidar", 12000, sm.parse("2022-01-02"),"HR"),
				new Employee(2, "Dev","apatidar", 11000, sm.parse("2022-01-02"),"ADMIN"));
		
		Function<Employee, String> firstName = Employee::getName;
		Function<Employee, String> lastName = Employee::getLastName;
		
		
		
		Comparator<Employee> thenComparing = Comparator.comparing(firstName).thenComparing(lastName);
		
		empList2.stream().sorted(thenComparing).forEach(System.out::println);
		
		List<Employee> empList3 = Arrays.asList(new Employee(1, "Zolly","Pal", 10000, sm.parse("2019-01-01"),"IT"),
				new Employee(2, "Dev","xpatidar", 10000, sm.parse("2022-01-02"),"IT"),
				new Employee(2, "Dev","patidar", 12000, sm.parse("2021-01-02"),"HR"),
				new Employee(2, "Ram","apatidar", 11000, sm.parse("2020-01-02"),"ADMIN"));
		
		Map<String, Long> mapDep = empList3.stream().collect(Collectors.groupingBy(x -> x.getDepartment(), Collectors.counting()));
		
		mapDep.forEach((k,v)->{
			
			System.out.println(k+" : "+v);
		});
		
		Collections.sort(empList3);
		
		System.out.println(empList3);
		
		Comparator<Employee> compEmp = (e1,e2) -> e1.getName().compareTo(e2.getName());
		
		empList3.sort(compEmp);
		
		System.out.println(empList3);
		
		Comparator<Employee> emComp = (e1,e2)-> e1.getName().compareTo(e2.getName());
		empList3.sort(emComp);
		List<Employee> sorted = empList3.stream().sorted((e1,e2) -> Double.compare(e1.getSalary(), e2.getSalary()) ).collect(Collectors.toList());
	
	empList.sort((e2,e3)-> e2.getName().compareTo(e3.getName()));
	
	Function<Employee, String> empName = Employee::getName;
	Function<Employee, Double> empSlr =Employee::getSalary;
	
	Comparator<Employee> empComp = Comparator.comparing(empName).thenComparing(empSlr);
	
	empList3.stream().sorted(empComp);
	
	Function<Employee,String> compFrst = Employee::getName;
	Function<Employee,Double> compSec = Employee::getSalary;
	
	Comparator<Employee> finalComp = Comparator.comparing(compFrst).thenComparing(compSec);
	
	empList3.sort(finalComp);
	
	
	TreeSet<String> ts = new TreeSet<>();
	HashSet<String> hs = new HashSet<>();
	
	hs.add("Hello");
	hs.add("Heena");
	hs.add("Raj");
	
	Predicate<String> preStr = (s1)->  s1.startsWith("H");
	
	hs.removeIf(preStr);
	
	System.out.println(hs);
	 HashSet < Integer > a = new HashSet < > (Arrays.asList(1, 2, 3, 4));
	    HashSet < Integer > b = new HashSet < > (Arrays.asList(1, 2, 5));
	    a.retainAll(b);

	    System.out.println(a);
	    
	    Map<String,String> map = new LinkedHashMap<>();
	}
	
	
}

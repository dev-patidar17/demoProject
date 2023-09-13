package com.test.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import net.bytebuddy.build.HashCodeAndEqualsPlugin.Sorted;

public class StreamProgram {

	public static void main(String[] args) {
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
		try {
			List<Employee> empList = Arrays.asList(new Employee(1, "Zolly", 10000, sm.parse("2022-01-01")),
					new Employee(2, "Dev", 10000, sm.parse("2022-01-02")),
					new Employee(2, "Dev", 12000, sm.parse("2022-01-02")),
					new Employee(2, "Heer", 11000, sm.parse("2022-01-02")));
			
			
			List<Employee> collect = empList.stream().sorted((obj1,obj2) -> Double.compare(obj1.getSalary(), obj2.getSalary())).collect(Collectors.toList());
			List<Employee> collect3 = empList.stream().sorted((obj1,obj2) -> (obj1.getLastName()).compareTo(obj2.getLastName())).collect(Collectors.toList());
			Map<Integer, Employee> collect2 = empList.stream().collect(Collectors.toMap(Employee::getId, Function.identity()));
			Map<Integer, Double> collect4 = empList.stream().collect(Collectors.groupingBy(Employee::getId, Collectors.averagingDouble(Employee::getSalary)));
			boolean allMatch = empList.stream().allMatch(obj -> (obj.getName()).startsWith("Dev"));
			Map<Integer, List<Employee>> collect5 = empList.stream().collect(Collectors.groupingBy(Employee::getId));
			
			List<List<Employee>> listOfEmpList = new ArrayList<>();
			
			listOfEmpList.add(empList);
			
			Map<Integer, Double> collect7 = listOfEmpList.stream().flatMap(objList -> objList.stream()).collect(Collectors.groupingBy(Employee::getId, Collectors.averagingDouble(Employee::getSalary)));
			List<Employee> collect6 = listOfEmpList.stream().flatMap(obj -> obj.stream()).collect(Collectors.toList());
			
			
			List<String> strLst = Arrays.asList("Hello","Hi","He");
			
			String reduce = strLst.stream().reduce((str1,str2) -> str1+"_"+str2).orElse("No Data Fund");
			
			Predicate<Integer> compareWithFive = (i) -> i>5;
			Predicate<Integer> compareWithEaght = (i) -> i>8; 
			
			compareWithFive.and(compareWithEaght).test(5);
			
			Function<Integer, Integer>  multiply = (i) -> { 
					i = i*5;
					return i;
			};
			Function<Integer, Boolean> checkValue = (j) -> {
				
				return j>5?true:false;
			};
			
			Boolean apply = multiply.andThen(checkValue).apply(5);
			
			
			Consumer<Double> comsumeDouble = (i) -> System.out.println(i);
			
			Consumer<Integer> comsumInt = (j) -> System.out.println(j);
			
			comsumeDouble.accept(10.2);
			comsumInt.accept(5);
			comsumeDouble.andThen(comsumeDouble).accept(4.4);
			
			
			Supplier<Integer> supplyInt = () -> 5*5;
			
			supplyInt.get();
			
			
			List<Employee> empList2 = Arrays.asList(new Employee(1, "Zolly","Pal", 10000, sm.parse("2022-01-01"),"IT"),
					new Employee(2, "Dev","xpatidar", 10000, sm.parse("2022-01-02"),"IT"),
					new Employee(2, "Dev","patidar", 12000, sm.parse("2022-01-02"),"HR"),
					new Employee(2, "Dev","apatidar", 11000, sm.parse("2022-01-02"),"ADMIN"));
			
			
			Function<Employee, String> byName = Employee::getName;
			Function<Employee, String> byLastName = Employee::getLastName;
			
			Comparator<Employee> empCom = Comparator.comparing(byName).thenComparing(byLastName);
			
			List<Employee> collect8 = empList.stream().sorted(empCom).collect(Collectors.toList());
			
			Comparator<Employee> com = (e1,e2) -> e1.compareTo(e2);
			
			empList.stream().sorted(com);
			
			Comparator<Employee> empCom1 = (e1,e2) -> e1.getName().compareTo(e2.getName());
			
			empList.stream().sorted(empCom1);
			
			
			
			Function<Employee,String> firstC = Employee::getName;
			Function<Employee,String> secondC = Employee::getLastName;
			
			Comparator<Employee> empCom11 = (c1,c2) -> c1.getName().compareTo(c2.getName());
			
			Comparator<Employee> empComparator2 = (e1,e2) -> e1.getLastName().compareTo(e2.getLastName());
			
			List<Employee> collect9 = empList.stream().sorted(empCom11.thenComparing(empComparator2)).collect(Collectors.toList());
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

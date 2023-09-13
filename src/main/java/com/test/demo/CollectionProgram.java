package com.test.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionProgram implements Serializable {
	
	public void demoTest(List<Employee> empList) {
		
		Function<Employee, String> comp1 = Employee::getName;
		
		Function<Employee,Date> comp2 = Employee::getDoj;
		
		Comparator<Employee> compare = Comparator.comparing(comp1).thenComparing(comp2);
		
		List<Employee> collect9 = empList.stream().sorted(compare).collect(Collectors.toList());
		
		List<Employee> collect5 = empList.stream().sorted((x,x1)-> Double.compare(x.getSalary(), x1.getSalary())).collect(Collectors.toList());
		
		List<Employee> collect6 = empList.stream().sorted((x,x1)-> x.getName().compareTo(x1.getName())).collect(Collectors.toList());
		
		Map<String, List<Employee>> collect = empList.stream().map(x-> {x.setName(x.getName().toUpperCase()); return x;}).collect(Collectors.groupingBy(x -> x.getName()));
		Map<Date, Long> collect2 = empList.stream().collect(Collectors.groupingBy(x -> x.getDoj(),Collectors.counting()));
		List<Employee> collect3 = empList.stream().sorted((x,x1) -> x.getName().compareTo(x1.getName())).collect(Collectors.toList());
		boolean allMatch = empList.stream().allMatch(x->x.getName().startsWith("De"));
		boolean anyMatch = empList.stream().anyMatch(x-> x.getName().startsWith("DE"));
		System.out.println("allMatch: "+allMatch+" anyMatch: "+anyMatch);
		
		Map<String, List<Employee>> collect4 = empList.stream().map(x-> {x.setName(x.getName().toLowerCase()); return x;}).collect(Collectors.groupingBy(x->x.getName()));
		Double avg = empList.stream().collect(Collectors.averagingDouble(x-> x.getSalary()));
		List<Employee> distinct = empList.stream().distinct().collect(Collectors.toList());
		empList.stream().forEachOrdered( x-> System.out.println(x.getName()));
		
		List<List<Employee>> listOfEmpList = new ArrayList<>();
		
		listOfEmpList.add(empList);
		
		 Map<String, Double> mapAvgSalary = listOfEmpList.stream().flatMap(x-> x.stream().map(y-> {
			y.setName(y.getName().toLowerCase()); 
			return y;
			})).collect(Collectors.groupingBy(p->p.getName(),Collectors.averagingDouble(q->q.getSalary())));
		 
		 List<Employee> collect7 = listOfEmpList.stream().flatMap(lst -> lst.stream().map(z-> {z.setDepartment(z.getDepartment()); return z;})).collect(Collectors.toList());
		 mapAvgSalary.forEach((k,v)->{
			 
			System.out.println(k+"...."+v);
		 });
		 List<Employee> collect8 = listOfEmpList.stream().flatMap(lst-> lst.stream().map(x-> {x.setDepartment(x.getDepartment()); return x; })).collect(Collectors.toList());
		 empList.stream().filter(x-> x.getName().startsWith("d")).forEach(x-> System.out.println(x.getName()));
		 
		// empList.stream().reduce((t, u) -> t.getSalary()+"-"+u.getSalary(),Double::sum);
		 
		
		 
		List<String> strLst = Arrays.asList("Hello","Hi","He");
		
		String result = strLst.stream().reduce((str1, str2) -> str1+"-"+str2).orElse("NO Value");
		String reduce = strLst.stream().reduce((x,x2) -> x+"()"+x2).orElse("No value");
		System.out.println(result);
		
		String result1 = strLst.stream().reduce("Start",(str1, str2) -> str1+"-"+str2);
		System.out.println(result1);
	}

	public static void main(String[] args) throws ParseException, CloneNotSupportedException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
		Employee emp, emp11; 
		try {
			 emp = Employee.class.newInstance();
			 emp11 = (Employee) Class.forName("com.test.demo.Employee").newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		List<Employee> empList = Arrays.asList(new Employee(1, "Zolly", 10000, sm.parse("2022-01-01")),
				new Employee(2, "Dev", 10000, sm.parse("2022-01-02")),
				new Employee(2, "Dev", 10000, sm.parse("2022-01-02")),
				new Employee(3, "Heer", 11000, sm.parse("2022-01-02")));
		
		
		
		//Map<Employee, String> empMap = empList.stream().collect(Collectors.toMap(Function.identity(), Employee::getName));
		
		Map<Employee, List<String>> map = new HashMap<>();
		
		for (Employee employee : empList) {
			if(map.containsKey(employee)) {
				List<String> list = map.get(employee);
				list.add(employee.getName());
				map.put(employee, list);
			}else {
				List<String> list = new ArrayList<>();
				list.add(employee.getName());
				map.put(employee, list);
			}
		}
		
		
		
		
		boolean equals = empList.get(1).equals(empList.get(2));
		
		CollectionProgram cl = new CollectionProgram();
		cl.demoTest(empList);
		
		Employee emp1 = Employee.getInstance();
		System.out.println(emp1);
		Employee emp2 = Employee.getInstance();
		System.out.println(emp2);
		
		Employee emp3 = new Employee(2, "Aman", 11000, sm.parse("2022-01-02"));
		
		Employee emp4 = (Employee)emp3.clone();
		
		Employee newInstance2 = (Employee)Class.forName("Employee").newInstance();
		
		Employee newInstance = Employee.class.newInstance();
		
		emp4.setName("Anju");
		
		System.out.println(emp4);
		
		
		TempInterface TI = ( a,  b)-> {System.out.println(a+b);
		return  a*b;};
		
		
		TempInterface TI2 = (a,b)-> {
			
			System.out.println("Hello, This is a lambda expresion here we are going to multiply"+a+" and "+b);
			return a*b;
		};
		
		int adding = TI.adding(10,30);
		System.out.println(adding);
		
		int adding2 = TI2.adding(6,7);
		System.out.println(adding2);
		
		Singleton singleton = Singleton.singleton();
		FileOutputStream f = new FileOutputStream("C://Users/user/Downloads/tpmm.txt");
		ObjectOutputStream ou = new ObjectOutputStream(f);
		ou.writeObject(singleton);
		
		FileInputStream fin = new FileInputStream("C://Users/user/Downloads/tpmm.txt");
		
		ObjectInputStream oin = new ObjectInputStream(fin);
		
		Singleton s = (Singleton)oin.readObject();
		System.out.println(s);
		FileInputStream fin2 = new FileInputStream("C://Users/user/Downloads/tpmm.txt");
		
		ObjectInputStream oin2 = new ObjectInputStream(fin2);
		Singleton s1 = (Singleton) oin2.readObject();
		
		System.out.println(s1);
		
		
		List<Integer> intList = Arrays.asList(20,30,5,40,30);
		
		Integer integer = intList.stream().sorted((x,x1)-> -Integer.compareUnsigned(x, x1)).collect(Collectors.toList()).get(1);
		
		System.out.println(integer);
		
		
		BiFunction<Employee, Employee, Employee> eomReturn = ( e1, e2)->{
			
			Employee rrr = new Employee();
			return rrr;
			
		};
		
		Employee emp41 = new Employee();
		Employee emp5 = new Employee();
		
		eomReturn.apply(emp41, emp5);
		
		
	}

	
	
	

}

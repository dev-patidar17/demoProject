package stream;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.web.server.MimeMappings.Mapping;

import com.test.demo.Employee;

public class StreamExamples {
	
	public void method(List<Employee> empList) {
		
		Comparator<Employee> com1 = (e1,e2)->Double.compare(e1.getSalary(),e2.getSalary());
		Comparator<Employee> com2 = (e1,e2)-> e1.getName().compareTo(e2.getName());
		
			List<Employee> sorted = empList.stream().sorted(com1).sorted(com2).collect(Collectors.toList());
		
			List<Integer> intList = Arrays.asList(2,4,6,3,7);
			
			int sum2 = intList.stream().filter(obj -> obj%2==0).mapToInt(objq -> objq).sum();
			System.out.println(sum2);
		
			Map<String, Employee> collect = empList.stream().collect(Collectors.toMap(Employee::getName, Function.identity()));
			
			Map<String, List<Employee>> collect2 = empList.stream().collect(Collectors.groupingBy(Employee::getName));
			
			Map<String, Long> collect3 = empList.stream().collect(Collectors.groupingBy(obj -> obj.getName(), Collectors.counting()));
			
			List<String> lst = Arrays.asList("PHP", "Java", "Dotnet", "Dotnet", "Python", "Python", "Java", "Python", "Java");
			
			Map<String, Long> collect10 = lst.stream().collect(Collectors.groupingBy(obj -> obj, Collectors.counting()));
			Map<String, Long> collect11 = lst.stream().filter(obj -> obj.startsWith("Do")).collect(Collectors.groupingBy(obj1 -> obj1, Collectors.counting()));
			
			
			
			Map<String, Long> collect4 = lst.stream().collect(Collectors.groupingBy(obj -> obj, Collectors.counting()));
			
			List<String> wordList = Arrays.asList("Hello", "Java", "Dotnet", "Moring", "Evenings");
		
			List<Integer> collect5 = wordList.stream().map(obj -> obj.length()).collect(Collectors.toList());			
			
			List<Employee> collect6 = empList.stream().sorted((e1,e2) -> Double.compare(e1.getSalary(), e2.getSalary())).collect(Collectors.toList());
			
			
			Comparator<Employee> empSalCom =  (e1,e2)-> Double.compare(e1.getSalary(), e2.getSalary());
			Comparator<Employee> empNameCom =  (e1,e2)-> (e1.getName()).compareTo(e2.getName());
			List<Employee> collect7 = empList.stream().sorted(empSalCom).sorted(empNameCom).collect(Collectors.toList());
			
			double sumOfSalary = empList.parallelStream().filter(obj -> obj.getName().equals("Dev") || obj.getName().equals("DevP")).mapToDouble(obj1 -> obj1.getSalary()).sum();
			
			
			double sum = empList.parallelStream().mapToDouble(obj -> obj.getSalary()).sum();
			
			
			
			lst.stream().skip(3);
			lst.stream().findAny();
			lst.stream().findFirst();
			
			
			//lst.stream().peek(null)
			System.out.println(collect7);
			
			Map<String, Long> collect8 = lst.stream().collect(Collectors.groupingBy(obj -> obj,Collectors.counting()));
			
			String name = "";
			Long value = 0l;
			
			for(Entry<String, Long> entrySet : collect8.entrySet()) {
				
				if(value< entrySet.getValue()) {
					value = entrySet.getValue();
					name = entrySet.getKey();
				}
			}
			
			System.out.println(name +"   "+value);
			
			lst.stream().collect(Collectors.groupingBy(obj -> obj,Collectors.counting()));
			
		Integer orElse = lst.stream().map(obj -> obj.length()).max((obj,obj2) -> obj.compareTo(obj2)).orElse(null);
		
		System.out.println(orElse);
		
		Map<String, Integer> collect9 = lst.stream().collect(Collectors.toMap(Function.identity(),String::length));
		
		
			
			
	}

	public static void main(String[] args) throws ParseException {
		StreamExamples se = new StreamExamples();
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
		
		List<Employee> empList = Arrays.asList(new Employee(1, "Zolly", 10000, sm.parse("2022-01-01")),
				new Employee(2, "Dev", 10000, sm.parse("2022-01-02")),
				new Employee(2, "DevP", 10000, sm.parse("2022-01-02")),
				new Employee(2, "Heer", 10000, sm.parse("2022-01-02")));
		se.method(empList);

	}

}

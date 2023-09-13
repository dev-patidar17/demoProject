package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestCof {

	public static void main(String[] args) {
		 
		
		 List<Integer> lst = Arrays.asList(5,5,7,5,7,12,88,100);
		 
		 Map<Integer, Long> collect = lst.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		 collect.forEach((k,y)->{
			 System.out.println(k+"---> "+y);
		 });
		
		 

	}

}

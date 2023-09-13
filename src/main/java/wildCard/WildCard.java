package wildCard;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;

public class WildCard {
	
	public String unboudWild(List<?> a) {
		
		a.stream().forEach(System.out::println);
		return null;
		
	}
	
	public static void main(String args[]) {
		
		WildCard wc = new WildCard();
		
		String ss = "Hello";
		List<String> asList = new ArrayList<>();
		asList.add("aaa");
		wc.unboudWild(asList);
		List<Double> doubleList = new ArrayList<>();
		doubleList.add(30.3);
		wc.unboudWild(doubleList);
	}
	
	public void upperBound(List<? extends Number> num) {
		
	}
	
	public void lowerBound(List<? super Integer> num ) {
		
	}

}

package collections;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeImplementation {

	public static void main(String[] args) {
		
		Comparator<String> cmp = (e1,e2)-> e2.compareTo(e1);
		
		Map<String, Integer> treeMap = new TreeMap<>(cmp);
		
		treeMap.put("Dev", 10);
		treeMap.put("Ashok", 1);
		treeMap.put("Bhau", 3);
		treeMap.put("Bhauu", 4);
		System.out.println(treeMap);
		
		

	}

}

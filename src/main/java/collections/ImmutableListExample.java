package collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;




public class ImmutableListExample {

	public static void main(String[] args) {
		
		List<String> list = List.of("S","D","K","L");
		
		list.add("jj");
		
		Collections.unmodifiableList(list);

	}

}

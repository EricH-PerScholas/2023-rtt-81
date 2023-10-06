package lambdas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StreamExample {

	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
		names.add("Larry");
		names.add("Steve");
		names.add("James");
		names.add("Conan");
		names.add("Ellen");

		// enhanced for loop
		for (String name : names) {
			System.out.println(name);
		}

		// using a list as a stream to do a for loop
		names.stream().forEach(name -> {
			String upper = name.toUpperCase();
			System.out.println(name);
		});

		// this is better than an using a loop to delete
		names.removeIf(name -> !name.startsWith("L"));

		// this is the old traditional way of filtering and removing an item from a list
		Iterator<String> it = names.iterator();
		while (it.hasNext()) {
			String name = it.next();
			if (!name.startsWith("L")) {
				// NOTE: Iterator's remove method, not ArrayList's, is used.
				it.remove();
			}
		}

	}

}

package collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import coffeeshop.Product;

public class MapExample {

	public static void main(String[] args) {
		
		HashMap<String,List<String>> dictionary;
		
		List<Map<String,Object>> rowInADatabase;
		
		HashMap<String, Integer> stringMap = new HashMap<>();
			
		// find all the products that are on sale 
		List<Product> saleProducts;

		stringMap.put("one", 1);
		stringMap.put("two", 2);

		Integer one = (Integer)stringMap.get("one");
		Integer two = stringMap.get("two");

		System.out.println(stringMap.get("one"));
		System.out.println(stringMap.get("two"));

		stringMap.put("one", 1000);

		System.out.println(stringMap.get("one"));

		Map<String, String> strings = new HashMap<>();
		strings.put("one", "This is a single item");
		strings.put("two", "This is two things");

		// hash maps allow nulls
		Map<Integer, String> numbers = new HashMap<>();
		numbers.put(1, "1st");
		numbers.put(2, "2nd");
		numbers.put(3, "3rd");
		numbers.put(4, "4th");
		numbers.put(40, "4th");
		numbers.put(50, null);
		numbers.put(null, "null");

		System.out.println("=============================");

		// to loop over a map .. we have to loop over the set of keys
		// for each key in the key set .. do something
		for (Integer key : numbers.keySet()) {
			// we have to use the key to look up the value
			String value = numbers.get(key);
			System.out.println(key + " = " + value);
		}
		
		numbers.get(null); // gives me back the string "null"
	}
}

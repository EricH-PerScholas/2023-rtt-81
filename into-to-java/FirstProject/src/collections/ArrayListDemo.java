package collections;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {

	public static void main(String[] args) {
		List<String> mylist = new ArrayList<String>();

		mylist.add("New Jersey"); // pos 0
		mylist.add("Dallas"); // pos 1
		mylist.add("New York"); // pos 2
		mylist.add("Chicago"); // pos 3
		mylist.add("LA"); // pos 4

		System.out.println("Return boolean :" + mylist.contains("Chicago"));
		System.out.println("Return index value of Element :" + mylist.indexOf("Chicago"));
		System.out.println("Returns the actual Element at the given index :" + mylist.get(2));
		System.out.println("Returns the length of the arraylist :" + mylist.size());
		// Remove the element at the given index. Returns the removed element.
		// remove element at index 3
		String removedElement = mylist.remove(3);
		System.out.println("Removed Element: " + removedElement);
		// remove all elements
		mylist.clear();
		System.out.println("ArrayList after clear(): " + mylist);
	}

}

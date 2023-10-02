package firstclass;

import java.util.ArrayList;
import java.util.List;

public class Review {

	public static void main(String[] args) {
		// truncation
		double pi = 3.14159;
		int pi2 = (int)pi;	
		
		// review of creating arrays
		int[] a; a = new int[10];
		
		int[] b = new int[8];

		int size = 1;
		int[] c = new int[size];

		String z;
		z = new String();

		String string = new String("12345");

		int[] d = { 1, 2, 3, 4, 5 };
		String[] aa = { "a", "b", "c" };
		
		
		
 		List<String> list = new ArrayList<>();
		// array.length
		int arrLen = b.length;
		string.length();
		list.size();
		
		// all new instances of a variable are Objects
		string.toString();
		list.toString();
		
		// cant do this because pi is a primitive
		//pi.toString();
		
		
		List<Object> anything = new ArrayList<>();
		
	
	}

}

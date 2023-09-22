package variables;

public class StringExamples {

	public static void main(String[] args) {
		String s1 = "welcome";
		String s2 = "Welcome";

		// these 2 things are not the same
		// this is actually a string in memory that 0 characters and length of 0
		String empty = "";
		// this is a string that has not been allocated in memory yet.
		String nullstring = null;
		String ns1 = null;
		
		if ( nullstring == ns1 ) {
			// this is true
		}
		
		if ( empty.equals(nullstring)) {
			// this will evaluate to false
		}
		
		if ( empty.equals("")) {
			// this is true
		}

		if (nullstring == null) {
			nullstring = new String("now its in memory");
		}

		// this is all okay with primitives
		int x = 5;
		int y = 6;
		if (x == y) {
		}

		// can not ever user == with strings
		// MUST always use .equals
		if (s1.equalsIgnoreCase(s2)) {
			System.out.println("The strings are equal");
		} else {
			System.out.println("The strings are not equal");
		}

		if (s1.toLowerCase().equals(s2.toLowerCase())) {
			// this is the same as equalsIgnoreCase
		}

		String upper = s1.toUpperCase();
		String lower = s1.toLowerCase();

		// make all of the lowercase e into E
		String s = new String("welcome");
		s = s.replaceAll("e", "E");
		System.out.println(s);
		
		String var = "   spaces before and after    ";
		var = var.trim();
		
		// what is the difference between 0 and 4 .... 1 and 5  -- the length is the same
		// string indexes are 0 based
		String pos = "abcdefghija";
		//        pos 01234567890
		int len = pos.length(); // 11
				
		int first = pos.indexOf('a'); // 0
		int last = pos.lastIndexOf('a'); // 10
				

	}

}

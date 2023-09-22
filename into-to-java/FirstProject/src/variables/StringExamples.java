package variables;

public class StringExamples {

	public static void main(String[] args) {
		String s1 = "welcome";
		String s2 = "Welcome";
		
		// this is all okay with primitives
		int x = 5;
		int y = 6;
	
		if ( x == y ) {
			
		}
		
		// can not ever user == with strings
		// MUST always use .equals
		if ( s1.equalsIgnoreCase(s2) ) {
			System.out.println("The strings are equal");
		} else {
			System.out.println("The strings are not equal");
		}
		
		if ( s1.toLowerCase().equals(s2.toLowerCase())) {
			// this is the same as equalsIgnoreCase
		}
		
		String upper = s1.toUpperCase();
		String lower = s1.toLowerCase();

		
		// make all of the lowercase e into E
		String s = new String("welcome");
		s = s.replaceAll("e", "E");
		System.out.println(s);
		
	}
	
}

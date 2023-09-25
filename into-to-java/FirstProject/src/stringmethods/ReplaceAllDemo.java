package stringmethods;

public class ReplaceAllDemo {

	public static void main(String[] args) {
	    String str1 = "Java123is456fun";

	    // regex for sequence of digits
	    String regex = "\\D{2}";

	    // replace all occurrences of numeric
	    // digits by a space
	    System.out.println(str1.replaceAll(regex, "_"));
	  }


}

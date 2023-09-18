package firstclass;

public class FirstClass {
	
	static final int DEFAULT_WIDTH = 10;
	
	
	// this is a single line comment
	public void function1() {
		
	}  
	
	/*
	 * this is a multi line
	 * comment because it begins with /*
	 * and ends with star slash
	 */
	public static void main(String[] args) {
		// this is another comment
		System.out.println("hello");  // this another comment after some code
		
		// variable names always start with lower case
		String variableName = "abc";
		
		String thisIsALongVariableName = "to long";
		
		String string = "s";
		
		// this is not a valid java variable name
		String variable_name = "not correct";
		
		Integer six = 5 + 1;
		
		int x = 5 + DEFAULT_WIDTH;
		
		System.out.println("x = " + x);
		
		x = x * 10;
		
		System.out.println("x = " + x);
		
		x = x + 5;
	}

}

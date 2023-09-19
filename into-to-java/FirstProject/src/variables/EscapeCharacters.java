package variables;

public class EscapeCharacters {

	public static void main(String[] args) {
		
		// the main ones to know are ... \t, \n, and \"
		
		// for the language java \ (slash) is the escape character
		
		// this is an example of the tab escape character \t
		System.out.println("This is a tab character ->\t<-");
		
		// basic formating with tabs
		// next 2 lines are the same, the first uses spaces
		// and the 2nd uses tabs.   Tabs are 1 character
		System.out.println("1       One             Col3");
		System.out.println("1\tOne\t\tCol3");
		
		// then we can add another row to create a table
		System.out.println("10\tTen\t\tCol3");
		//this one is long so it only needs 1 tab for the 3rd column
		System.out.println("100\tOne Hundred\tCol3"); 
		
		// this is an example of a new line character \n
		System.out.println("This is line 1\nThis is line 2");
		System.out.println("This is line 3");
		System.out.println("This is line 4");
		
		
		// what happens if I want to print just a \
		System.out.println("To get a slash to print we need 2 of them \\");
		
		// what happens if I want a " in my string
		System.out.println("This is a quote \" in a string ");
	}
	
}

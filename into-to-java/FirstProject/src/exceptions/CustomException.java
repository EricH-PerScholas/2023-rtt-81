package exceptions;

// first thing is to make the class extends Exception
public class CustomException extends Exception {
	
	// create a constructor that take in a string message and calls super(message);
	public CustomException(String message) {
		super(message);
	}
	
}

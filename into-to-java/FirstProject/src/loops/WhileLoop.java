package loops;

public class WhileLoop {

	public static void main(String[] args) {
		
		int count = 1;
		
		boolean condition = true;
		
		while(condition) {
			System.out.println("Will run forever.");
			condition = false;
			count = count + 1;
		}
		
	}

}

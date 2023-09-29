package calc;

import java.util.Scanner;

public class Calculator {
	
	public static final Integer CONSTANT = 10;

	private Scanner scanner = new Scanner(System.in);

	// Create a small calculator .. it will be able to do 4 operations - add,
	// subtract, multiply and divide. Each of these will be a single method that
	// does that operation. Ask the user for 2 numbers and then ask the user which
	// operation they want to do. Then do that operation and print the result. Each
	// operation should not print its own results. All operations should work with
	// double values. (edited)
	// So this should be a main function with probably 6 methods ( 4 operations, 1
	// menu, 1 input )
	// each operation should take 2 parameters and return a double ...

	public static void main(String[] args) {
		Calculator c = new Calculator();
		c.menu();
	}

	public void menu() {
		// start writing your code here
		System.out.println("1) Add");
		System.out.println("2) Subtract");
		System.out.println("3) Multiply");
		System.out.println("4) Divide");

		System.out.println("Enter the operation :");

		int menu = scanner.nextInt();

		double n1 = input();
		double n2 = input();

		Double answer = null;
		if (menu == 1) {
			answer = sum(n1, n2);
		} else if (menu == 2) {
			answer = subtract(n1, n2);
		} else if (menu == 3) {
			answer = multiply(n1, n2);
		} else if (menu == 4) {
			answer = divide(n1, n2);
		} else {
			System.out.println("Invalid menu entry");
			System.exit(1);
		}

		System.out.println("The answer is " + answer);

	}

	public double input() {
		System.out.println("Enter number :");
		double input = scanner.nextDouble();
		return input;
	}

	public double sum(double n1, double n2) {
		return n1 + n2;
	}

	public double subtract(double n1, double n2) {
		return n1 - n2;
	}

	public double multiply(double n1, double n2) {
		return n1 * n2;
	}

	public double divide(double n1, double n2) {
		return n1 / n2;
	}

}

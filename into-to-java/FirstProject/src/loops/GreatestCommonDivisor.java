package loops;

import java.util.Scanner;

public class GreatestCommonDivisor {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int n1 = readPositiveNumber(scanner);
		int n2 = readPositiveNumber(scanner);
		
		System.out.println("First number  : " + n1);
		System.out.println("Second number : " + n2);
		
		//Check whether k (for k = 2, 3, 4, and so on) is a common divisor 
		// for n1 and n2, until k is greater than n1 or n2.
		
		// we are looking for where both numbers are divisible with no remainder
		
		// 5 and 15
		// 5 / 1 = 5   , 15 / 1 = 15    = Good !!! 
		// 5 / 2 = 2.x , 15 / 2 = 7.x   = No good
		// 5 / 3 = 1.x , 15 / 3 = 5     = No good
		// 5 / 4 = 1.x , 15 / 4 = 3.x   = No good
		// 5 / 5 = 1   , 15 / 5 = 3     = Good !!!
		// 5 / 6 = 0.x ,
		// 5 / 7 = 0.x ,
		
		int gcd = 1;
		int min = Math.min(n1, n2);
	
		for ( int k = 1 ; k <= min  ; k++ ) {
			if ( (n1 % k == 0) && (n2 % k == 0) ) {
				gcd = k;
			}
		}
		
		System.out.println("The gcd of " + n1 + " and " + n2 + " is " + gcd);
	}
	
	public static int readPositiveNumber(Scanner scanner) {
		int number = -1;
		while ( number <= 0 ) {
			System.out.print("Enter a positive integer greater than 0 : ");
			number = scanner.nextInt();
			
			if ( number <= 0 ) {
				System.out.println("Error : Must be a positive number");
			} 
		}
		
		return number;
	}
	
}

package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Task11 {

	public static void main(String[] args) {

		// Task 11: Write some Java code that asks the user how many favorite things
		// they have. Based on their answer, you should create a String array of the
		// correct size. Then ask the user to enter the things and store them in the
		// array you created. Finally, print out the contents of the array.
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("How many favorite things? ");
		int numFavorites = scanner.nextInt();
		scanner.nextLine();
		
		String[] favorites = new String[numFavorites];
		
		for ( int pos = 0 ; pos < numFavorites ; pos++ ) {
			System.out.println("Enter favrotie thing #" + pos);
			favorites[pos] = scanner.nextLine();
		}
		
		System.out.println(Arrays.toString(favorites));
	}

}

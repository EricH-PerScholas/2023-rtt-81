package arrays;

import java.util.Arrays;

public class ArrayExample {

	public static void main(String[] args) {
		int arraySize = 10;

		// this creates a new array of type double with 20 elements ... 0 to 19
		double[] doubleArray = new double[arraySize];
		Arrays.fill(doubleArray,5.5);

		String[] stringArray = new String[arraySize];
		stringArray[1] = "one";
		stringArray[2] = "two";
		stringArray[0] = "zero";
		stringArray[9] = "nine";

		// this is going to fail and cause code execution to stop
		// stringArray[11] = "eleven";

		// loop over the entire array and print the value in each location
		// its important to know that you can ask an array how long it is using .length
		for (int pos = 0; pos < stringArray.length; pos++) {
			System.out.println("The value in position " + pos + " is " + stringArray[pos]);
		}

		System.out.println("=========================");

		// enhanced for loop
		for (String value : stringArray) {
			System.out.println("The value = " + value);
		}

		System.out.println("=========================");

		// write a for loop that counts the number of nulls in the array
		// after the loop completes print that number
		int nullCount = 0;
		for (String value : stringArray) {
			if (value == null) {
				nullCount = nullCount + 1;
			}
		}
		System.out.println("Number of nulls is " + nullCount);

		// write a for loop that tells me the location of the first null in the array
		// this is going to use the non-enhanced for loop
		int firstNull = -1;
		for (int pos = 0; pos < stringArray.length; pos++) {
			if (stringArray[pos] == null) {
				firstNull = pos;
				break;
			}
		}

		// write a for loop that tells me how many values are not null
		// this is using an old style for loop with an array location
		int notNullCount = 0;
		for (int pos = 0; pos < stringArray.length; pos++) {
			if (stringArray[pos] != null) {
				notNullCount = notNullCount + 1;
			}
		}
		System.out.println("Number of null values in array is " + notNullCount);

		// same solution with an enhance for loop -- this is a little bit more simple
		// solution
		// with the enhanced for loop you are not able to get the position of the value
		// in the array
		int notNullCountEnhanced = 0;
		for (String value : stringArray) {
			if (value != null) {
				notNullCountEnhanced = notNullCountEnhanced + 1;
			}
		}
		System.out.println("Number of null values in array is " + notNullCountEnhanced);

		// write a for loop that tells me the last position of null in the array
		// by last null position we mean the position with the highest value
		// this looks at all 10 values in the array
		int lastNullPosition = -1;
		for (int pos = 0; pos < stringArray.length; pos++) {
			if (stringArray[pos] == null) {
				lastNullPosition = pos;
			}
		}
		if (lastNullPosition == -1) {
			System.out.println("The array does not have a null");
		} else {
			System.out.println("The last null of the array is in position " + lastNullPosition);
		}

		// more efficient because it can break the loop once it found its answer
		// starts at the end of the array and counts down to the first
		int lastNullPositionReverse = -1;
		for (int pos = stringArray.length - 1; pos >= 0; pos--) {
			if (stringArray[pos] == null) {
				lastNullPositionReverse = pos;
				break;
			}
		}
		if (lastNullPositionReverse == -1) {
			System.out.println("The array does not have a null");
		} else {
			System.out.println("The last null of the array is in position " + lastNullPositionReverse);
		}

		// use letters.split(",") to make an array of letters
		// loop over the array and count the number of letters that are not vowels
		String letters = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z";

		String[] lettersArray = letters.split(",");
		int numberOfLetters = 0;
		for (int pos = 0; pos < lettersArray.length; pos++) {
			if (lettersArray[pos].equals("a")) {
				continue;
			} else if (lettersArray[pos].equals("e")) {
				continue;
			} else if (lettersArray[pos].equals("i")) {
				continue;
			} else if (lettersArray[pos].equals("o")) {
				continue;
			} else if (lettersArray[pos].equals("u")) {
				continue;
			}

			numberOfLetters = numberOfLetters + 1;
		}
		System.out.println("Number of letters = " + numberOfLetters);

		// using an enhanced loop and much less code
		String vowels = "aeiou";

		int numberOfLettersEnhanced = 0;
		for (String letter : letters.split(",")) {
			if (!vowels.contains(letter)) {
				numberOfLettersEnhanced = numberOfLettersEnhanced + 1;
			}
		}
		System.out.println("Number of letters enhanced = " + numberOfLettersEnhanced);
		
		
		// this is basically doing a for loop and printing the result
		System.out.println(Arrays.toString(lettersArray));

	}

}

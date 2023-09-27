package arrays;

import java.util.Arrays;

public class Task8 {

	public static void main(String[] args) {

		// Write a program that creates a String array of 5 elements and swaps the first
		// element with the middle element without creating a new array.
		
		String[] strings = { "1", "2", "3", "4", "5" };
		
		System.out.println(Arrays.toString(strings));
		
		String temp = strings[0];
		strings[0] = strings[2];
		System.out.println(Arrays.toString(strings));
		
		strings[2] = temp;

		System.out.println(Arrays.toString(strings));
		
	}
}

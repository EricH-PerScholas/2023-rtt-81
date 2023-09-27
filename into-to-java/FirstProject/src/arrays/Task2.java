package arrays;

public class Task2 {

	public static void main(String[] args) {

		// Write a program that returns the middle element in an array. Give the
		// following values to the integer array: {13, 5, 7, 68, 2} and produce the
		// following output: 7

		int[] arr = { 13, 5, 7, 68, 2 };
		
		System.out.println(arr[2]);
		System.out.println(arr[arr.length / 2]);

	}
}

package variables;

import java.util.Scanner;

public class RectangleArea {

	public static void main(String[] args) {
		// create an Object of Scanner class
		Scanner input = new Scanner(System.in);

		System.out.print("Enter the height: ");
		int height = input.nextInt();
		
		System.out.print("Enter the width: ");
		int width = input.nextInt();
		
		// calculate the area
		int area = height * width;
		
		if ( height == width ) {
			System.out.println("The height and width are the same so this is a square");
		}
		
		System.out.println("Area of the rectangle is = " + area);
		
	}

}

package loops;

public class SBAReview {

	public static void main(String[] args) {
		// when we multiply a number by 10 .. it moves the decimal point right
		// 1 * 10 = 10
		// 10 * 10 = 100
		// 100 * 10 = 1000
		// 1000 * 10 = 10000

		// when we divide by 10 .. it moves the decimal point left
		// 1000 / 10 = 100
		// 100 / 10 = 10
		// 10 / 10 = 1
		// 1 / 10 = 0.1
		// 0.1 / 10 = 0.01

		// this is using int primitive (x) to automatically truncate the remainder
		// figure out the length of 8763 = 4
		// 8763 / 10 = 876
		// 876 / 10 = 87
		// 87 / 10 = 8
		// 8 / 10 = 0 - when (x == 0) then you know you hit the end

		// for our case assume that a mod will always be a positive whole number int
		// 8763 % 10 = 3
		// 876 % 10 = 6
		// 87 % 10 = 7
		// 8 % 10 = 8

		int x = 8763 / 10; // this gets us the whole number 876
		int y = 8763 % 10; // this gets us the remainder 3

		x = x / 10;
		

	}
}

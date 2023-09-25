package controlflow;

public class Question7 {

	public static void main(String[] args) {

		String filingStatus = "Single";
		int income = 5000;
		double percent = 0;

		if (filingStatus.equals("Single")) {
			if (income >= 0 && income <= 8500) {
				percent = 10;
			} else if (income > 8500 && income <= 33950) {
				percent = 15;
			}
		} else if (filingStatus.equals("Married Joint")) {

		}
	}
}

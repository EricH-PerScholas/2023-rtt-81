package stringmethods;

public class SubsstringDemo {

	public static void main(String[] args) {

		// --------------0123456789012345
		String string = "This is a string";

		// substring with a start and an end
		String sub = string.substring(5, 7);
		System.out.println(sub);

		// substring with just a start
		String sub1 = string.substring(5);
		System.out.println(sub1);

		// ----------------0123456789012
		String filename = "someimage.jpg";

		int lastDot = filename.lastIndexOf(".");

		String ext = filename.substring(filename.lastIndexOf(".") + 1);
		System.out.println(ext);

		// ------------01234567890
		String name = "Eric Heilig";

		int spacePosition = name.indexOf(" ");
		String firstname = name.substring(0, spacePosition);
		System.out.println(firstname);

		String lastname = name.substring(name.indexOf(" ") + 1);
		System.out.println(lastname);

		// find the position of the first space in the string
		String example = "This is an example!";

		// find the position of the last space in the string
		int lastSpace = example.lastIndexOf(" ");
		int firstSpace = example.indexOf(" ");

		// substring of the characters between the first and last space of the string
		String chrBetween = example.substring(firstSpace + 1, lastSpace);
		System.out.println("---->" + chrBetween);

		// this is pretty hard - I dont really like this question
		// do the same thing to find the substring of the first and last vowel of the
		// string
		int firstVowelPosition =0;
		int lastVowelPosition = 0;

		for (int i = 0; i < example.length(); i++) {
			if (example.charAt(i) == 'a' || example.charAt(i) == 'e' || example.charAt(i) == 'i'
					|| example.charAt(i) == 'o' || example.charAt(i) == 'u') {
				firstVowelPosition = i;
				break;
				// lastVowelPosition=example.lastIndexOf(i);
			}
		}
		for (int j = 0; j < example.length(); j++) {
			if (example.charAt(j) == 'a' || example.charAt(j) == 'e' || example.charAt(j) == 'i'
					|| example.charAt(j) == 'o' || example.charAt(j) == 'u') {
				lastVowelPosition = j;

			}
		}

		System.out.println("\n\nSubstring between the first and last vowel of the string: "
				+ example.substring(firstVowelPosition, lastVowelPosition));

		// use the string.charAt function and use a for loop to loop over the entire
		// string
		// and print out each character with a new line after it.
		// you need to use the string.length() function also
		for (int pos = 0; pos < example.length(); pos++) {
			// not that using an array is slightly different in that it uses [] to reference
			// the position.
			System.out.println(example.charAt(pos));
		}

		// using only indexOf(" ") print the substring that contains the word "is"
		// use 2 substrings to do this.
		// String example = "This is an example!";
		String is = example.substring(example.indexOf(" ") + 1);
		is = is.substring(0, is.indexOf(" "));
		System.out.println(is);

		// https://edabit.com/challenges
		// Change to Java / Very Easy or Easy / Strings and try to do some of them

	}

}

package convert.dev;

public class RomanNumeral {

	private final int num; // The number represented by this Roman numeral.
	private static int[] numbers = { 1000, 500, 100, 50, 10, 5, 1 };
	private static String[] letters = { "M", "D", "C", "L", "X", "V", "I" };

	public RomanNumeral(int arabic) {
		if (arabic < 1)
			throw new NumberFormatException("Value of RomanNumeral must be positive.");
		if (arabic > 3000)
			throw new NumberFormatException("Value of the number is greater than 3000 the calculator can handle");
		num = arabic;
	}

	public RomanNumeral(String roman) {
		if (roman.length() == 0)
			throw new NumberFormatException("An empty string does not define a Roman numeral.");
		roman = roman.toUpperCase(); // Convert to upper case letters.
		int i = 0; // A position in the string, roman;
		int arabic = 0;
		while (i < roman.length()) {
			char letter = roman.charAt(i); // Letter at current position in
			int number = letterToNumber(letter);
			if (number < 0)
				throw new NumberFormatException("Illegal character \"" + letter + "\" in roman numeral.");
			i++;
			if (i == roman.length()) {
				arabic += number;
			} else {
				int nextNumber = letterToNumber(roman.charAt(i));
				if (nextNumber > number) {
					// Combine the two letters to get one value, and move on to
					// next position in string.
					arabic += (nextNumber - number);
					i++;
				} else {
					arabic += number;
				}
			}
		}
		if (arabic > 3000)
			throw new NumberFormatException("Roman numeral is greater than 3000 the calculator can handle");
		num = arabic;
	}

	private int letterToNumber(char letter) {
		switch (letter) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return -1;
		}
	}

	public String toString() {
		// Return the standard representation of this Roman numeral.
		String roman = "";
		int N = num;
		for (int i = 0; i < numbers.length; i++) {
			while (N >= numbers[i]) {
				roman += letters[i];
				N -= numbers[i];
			}
		}
		return roman;
	}

	public int toInt() {
		return num;
	}
}

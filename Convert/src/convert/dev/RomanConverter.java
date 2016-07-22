package convert.dev;

public class RomanConverter {

	public static void main(String[] args) {

		TextIO.putln("Enter a Roman numeral and I will convert it to Numerical values");
		TextIO.putln("Enter Arabic Numerical(0-9) value in the range 1 to 3000");
		/*
		 * Skip the any blanks at the beginning of the input line. Break out of
		 * the loop if there is nothing else on the line.
		 */
		while (true) {
			TextIO.putln();
			TextIO.put("Enter Input Value: ");
			while (TextIO.peek() == ' ' || TextIO.peek() == '\t')
				TextIO.getAnyChar();
			if (TextIO.peek() == '\n')
				break;
			/*
			 * If the first non-blank character is a digit, read an arabic
			 * numeral and convert it to a Roman numeral. Otherwise, read a
			 * Roman numeral and convert it to an arabic numeral.
			 */
			if (Character.isDigit(TextIO.peek())) {
				int arabic = TextIO.getlnInt();
				try {
					RomanNumeral N = new RomanNumeral(arabic);
					TextIO.putln(N.toInt() + " = " + N.toString());
				} catch (NumberFormatException e) {
					TextIO.putln("the number is not a valid number.");
					TextIO.putln(e.getMessage());
				}
			} else {
				String roman = TextIO.getln();
				try {
					RomanNumeral N = new RomanNumeral(roman);
					TextIO.putln(N.toString() + " = " + N.toInt());
				} catch (NumberFormatException e) {
					TextIO.putln("the number is not a valid number.");
					TextIO.putln(e.getMessage());
				}
			}

		}

	}
}

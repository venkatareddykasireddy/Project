package convert.dev;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextIO {

	public final static char EOF = (char) 0xFFFF;
	public final static char EOLN = '\n';

	private static void skipWhitespace() {
		char ch = lookChar();
		while (ch != EOF && Character.isWhitespace(ch)) {

			readChar();
			if (ch == '\n' && readingStandardInput && writingStandardOutput) {
				out.print("? ");
				out.flush();
			}
			ch = lookChar();
		}
	}

	public static void put(Object x) {
		out.print(x);
		out.flush();
		if (out.checkError())
			outputError("Error while writing output.");
	}

	public static void putln(Object x) {
		out.println(x);
		out.flush();
		if (out.checkError())
			outputError("Error while writing output.");
	}

	public static void putln() {
		out.println();
		out.flush();
		if (out.checkError())
			outputError("Error while writing output.");
	}

	public static boolean eoln() {
		return peek() == '\n';
	}

	public static boolean eof() {
		return peek() == EOF;
	}

	public static char getAnyChar() {
		return readChar();
	}

	public static char peek() {
		return lookChar();
	}

	public static int getlnInt() {
		int x = getInt();
		emptyBuffer();
		return x;
	}

	public static int getInt() {
		return (int) readInteger(Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static String getln() {
		StringBuffer s = new StringBuffer(100);
		char ch = readChar();
		while (ch != '\n') {
			s.append(ch);
			ch = readChar();
		}
		return s.toString();
	}

	private static String inputFileName;
	private static String outputFileName;
	private final static BufferedReader standardInput = new BufferedReader(new InputStreamReader(System.in));
	private final static PrintWriter standardOutput = new PrintWriter(System.out);
	private static BufferedReader in = standardInput;
	private static PrintWriter out = standardOutput;
	private static boolean readingStandardInput = true;
	private static boolean writingStandardOutput = true;
	private static int inputErrorCount;
	private static int outputErrorCount;
	private static Matcher integerMatcher;
	private final static Pattern integerRegex = Pattern.compile("(\\+|-)?[0-9]+");
	private static String buffer = null;
	private static int pos = 0;

	private static String readIntegerString() {
		skipWhitespace();
		if (lookChar() == EOF)
			return null;
		if (integerMatcher == null)
			integerMatcher = integerRegex.matcher(buffer);
		integerMatcher.region(pos, buffer.length());
		if (integerMatcher.lookingAt()) {
			String str = integerMatcher.group();
			pos = integerMatcher.end();
			return str;
		} else
			return null;
	}

	private static long readInteger(long min, long max) {
		long x = 0;
		while (true) {
			String s = readIntegerString();
			if (s == null) {
				errorMessage("Integer value not found in input.", "Integer in the range " + min + " to " + max);
			} else {
				String str = s.toString();
				try {
					x = Long.parseLong(str);
				} catch (NumberFormatException e) {
					errorMessage("Illegal integer input, " + str + ".", "Integer in the range " + min + " to " + max);
					continue;
				}
				if (x < min || x > max) {
					errorMessage("Integer input outside of legal range, " + str + ".",
							"Integer in the range " + min + " to " + max);
					continue;
				}
				break;
			}
		}
		inputErrorCount = 0;
		return x;
	}

	private static void errorMessage(String message, String expecting) {
		if (readingStandardInput && writingStandardOutput) {
			out.println();
			out.print("  *** Error in input: " + message + "\n");
			out.print("  *** Expecting: " + expecting + "\n");
			out.print("  *** Discarding Input: ");
			if (lookChar() == '\n')
				out.print("(end-of-line)\n\n");
			else {
				while (lookChar() != '\n')
					out.print(readChar());
				out.print("\n\n");
			}
			out.print("Please re-enter: ");
			out.flush();
			readChar();
			inputErrorCount++;
			if (inputErrorCount >= 10)
				throw new IllegalArgumentException("Too many input consecutive input errors on standard input.");
		} else if (inputFileName != null)
			throw new IllegalArgumentException("Error while reading from file \"" + inputFileName + "\":\n" + message
					+ "\nExpecting " + expecting);
		else
			throw new IllegalArgumentException(
					"Error while reading from inptu stream:\n" + message + "\nExpecting " + expecting);
	}

	private static char lookChar() {
		if (buffer == null || pos > buffer.length())
			fillBuffer();
		if (buffer == null)
			return EOF;
		else if (pos == buffer.length())
			return '\n';
		else
			return buffer.charAt(pos);
	}

	private static char readChar() {
		char ch = lookChar();
		if (buffer == null) {
			if (readingStandardInput)
				throw new IllegalArgumentException("Attempt to read past end-of-file in standard input???");
			else
				throw new IllegalArgumentException(
						"Attempt to read past end-of-file in file \"" + inputFileName + "\".");
		}
		pos++;
		return ch;
	}

	private static void fillBuffer() {
		try {
			buffer = in.readLine();
		} catch (Exception e) {
			if (readingStandardInput)
				throw new IllegalArgumentException("Error while reading standard input???");
			else if (inputFileName != null)
				throw new IllegalArgumentException(
						"Error while attempting to read from file \"" + inputFileName + "\".");
			else
				throw new IllegalArgumentException("Errow while attempting to read form an input stream.");
		}
		pos = 0;
		integerMatcher = null;
	}

	private static void emptyBuffer() {
		buffer = null;
	}

	private static void outputError(String message) {
		if (writingStandardOutput) {
			System.err.println("Error occurred in TextIO while writing to standard output!!");
			outputErrorCount++;
			if (outputErrorCount >= 10) {
				outputErrorCount = 0;
				throw new IllegalArgumentException("Too many errors while writing to standard output.");
			}
		} else if (outputFileName != null) {
			throw new IllegalArgumentException(
					"Error occurred while writing to file \"" + outputFileName + "\":\n   " + message);
		} else {
			throw new IllegalArgumentException("Error occurred while writing to output stream:\n   " + message);
		}
	}

}
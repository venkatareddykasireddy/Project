package test.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import convert.dev.RomanNumeral;

public class TestMaxValue {

	@Test
	public void NativeValues() {
		System.out.println("the number is greater than 3000 the calculator can handle");
		RomanNumeral N = new RomanNumeral(3001);

		assertEquals("Value of RomanNumeral must be 3000 or less", N.toString());

	}

}

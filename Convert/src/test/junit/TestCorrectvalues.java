package test.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import convert.dev.RomanNumeral;

public class TestCorrectvalues {

	@Test
	public void RomanValues() {
		RomanNumeral N = new RomanNumeral(1);
		assertEquals("I", N.toString());
		RomanNumeral N1 = new RomanNumeral(3000);
		assertEquals("MMM", N1.toString());
	}

}

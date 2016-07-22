package test.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import convert.dev.RomanNumeral;

public class Testvalue_XL {

	@Test
	public void RomanValues() {
		RomanNumeral N = new RomanNumeral("XL");
		assertEquals(40, N.toInt());
	}

}

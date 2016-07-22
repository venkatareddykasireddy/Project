package test.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import convert.dev.RomanNumeral;

public class Testvalue_XC {

	@Test
	public void RomanValues() {
		RomanNumeral N = new RomanNumeral("XC");
		assertEquals(90, N.toInt());
	}

}

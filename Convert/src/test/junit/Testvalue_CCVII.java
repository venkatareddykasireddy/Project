package test.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import convert.dev.RomanNumeral;

public class Testvalue_CCVII {

	@Test
	public void RomanValues() {
		RomanNumeral N = new RomanNumeral("CCVII");
		assertEquals(207, N.toInt());
	}

}

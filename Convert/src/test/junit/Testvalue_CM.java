package test.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import convert.dev.RomanNumeral;

public class Testvalue_CM {

	@Test
	public void RomanValues() {
		RomanNumeral N = new RomanNumeral("CM");
		assertEquals(900, N.toInt());
	}

}

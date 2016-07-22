package test.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import convert.dev.RomanNumeral;

public class Testvalue_IV {

	@Test
	public void RomanValues() {
		RomanNumeral N = new RomanNumeral("IV");
		assertEquals(4, N.toInt());
	}

}

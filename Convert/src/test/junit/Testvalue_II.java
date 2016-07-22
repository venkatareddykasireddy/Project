package test.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import convert.dev.RomanNumeral;

public class Testvalue_II {

	@Test
	public void RomanValues() {
		RomanNumeral N = new RomanNumeral("II");
		assertEquals(2, N.toInt());
	}

}

package test.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import convert.dev.RomanNumeral;

public class Testvalue_IX {

	@Test
	public void RomanValues() {
		RomanNumeral N = new RomanNumeral("IX");
		assertEquals(9, N.toInt());
	}

}

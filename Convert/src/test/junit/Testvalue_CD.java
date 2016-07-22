package test.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import convert.dev.RomanNumeral;

public class Testvalue_CD {

	@Test
	public void RomanValues() {
		RomanNumeral N = new RomanNumeral("CD");
		assertEquals(400, N.toInt());
	}

}

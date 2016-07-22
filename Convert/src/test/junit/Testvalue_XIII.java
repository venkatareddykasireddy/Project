package test.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import convert.dev.RomanNumeral;

public class Testvalue_XIII {

	@Test
	public void RomanValues() {
		RomanNumeral N = new RomanNumeral("XIII");
		assertEquals(13, N.toInt());
	}

}

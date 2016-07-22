package test.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import convert.dev.RomanNumeral;

public class Testvalue_MLXVI {

	@Test
	public void RomanValues() {
		RomanNumeral N = new RomanNumeral("MLXVI");
		assertEquals(1066, N.toInt());
	}

}

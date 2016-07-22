package test.junit;

import org.junit.Test;

import convert.dev.RomanNumeral;
import junit.framework.TestCase;

public class TestNativeValues extends TestCase {

	@Test
	public void NativeValues() {
		System.out.println("Value should be positive");
		RomanNumeral N = new RomanNumeral(-1);
		assertEquals("Value should be positive", N.toString());

	}

}

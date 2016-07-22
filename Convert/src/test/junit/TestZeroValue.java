package test.junit;

import org.junit.Test;

import convert.dev.RomanNumeral;
import junit.framework.TestCase;


public class TestZeroValue extends TestCase {
	
	 @Test
	public void NativeValues()
	{
		 System.out.println("Value should be minmum 1");
		RomanNumeral N = new RomanNumeral(0);	
		assertEquals("Value should be minmum 1", N.toString());
		
	}

}

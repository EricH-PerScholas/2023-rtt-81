package perscholas.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

	@Test
	public void additionTest() {
		Calculator c = new Calculator();
		double expected = 10.0;
		
		double actual = c.add(5.0, 5.0);
		
		Assertions.assertEquals(expected,actual);
		
		Assertions.assertEquals(15.0, c.add(7.5,7.5));
	}
	
	@Test
	public void subtractionTest() {
		Calculator c = new Calculator();
		double expected = 0.0;
		
		double actual = c.subtract(5.0, 5.0);
		
		Assertions.assertEquals(expected,actual);
		
		Assertions.assertEquals(15.0, c.subtract(20.0, 5.0));
	}
	
}

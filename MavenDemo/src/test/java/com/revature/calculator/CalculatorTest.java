package com.revature.calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

	private Calculator c; 
		
	@Before 
	public void setCalculator() {
		this.c = new Calculator();
	}
	/*
	 * TDD:
	 * 
	 * red-green refactoring
	 * start with requirement, write test, build code to match
	 * 
	 * Calculator requirements:
	 * (Calculator class)
	 * 
	 * 1. Has an add() method which takes a String parameter
	 * 		and returns a String
	 * 2. Calling add() with two comma-separated values return the sum of those values
	 * 3. calling add() with null returns zero
	 * 4. calling add() with > 2 arguments throws exception
	 * 5. calling add() with incorrect characters  (anything but , and Double 
	 * throws CalculatorException
	 */

	
	@Test 
	public void emptyStringReturnsZero() {
		assertEquals(0, c.add(""),.001); // floating-point assertions require an offset		
	}
	
	@Test 
	public void twoNumbersReturnsSum() {
		assertEquals(28.2, c.add("12.9, 15.3"), .001);
	}
}

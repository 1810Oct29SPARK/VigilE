package com.revature.demo;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class JUnitProcedureTest {
		
	/*
	 * executes before each Test
	 */
	
	@Before 
	public void beforeTests() {
		System.out.println("in beforeTests");
	}
	
	/*
	 * executes before all Test
	 */
	
	@BeforeClass
	public static void beforeAllTests() {
		System.out.println("in beforeAllTests");
	}
	/*
	 * executes after each test
	 */
	@After 
	public void afterTests() {
		System.out.println("in afterTests");
	}
	/*
	 * executes after each test
	 */
	@AfterClass 
	public static void afterAllTests() {
		System.out.println("in afterAllTests");
	}
	
	@Test
	public void testCase1() {
		System.out.println("in testCase1");
		
	}
	
	@Ignore
	@Test
	public void testCase2() {
		System.out.println("in testCase2");
		fail();
		
	}

}

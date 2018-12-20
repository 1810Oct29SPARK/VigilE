package com.revature.calculator;

public class Calculator {

	public Calculator() {
		// TODO Auto-generated constructor stub
	}
	
	public Double add(String toAdd) {
		Double sum = 0.0;
		if (!toAdd.equals("")) {
			String[] numbers = toAdd.split(",");
			for (String number : numbers) {
				// parse the values as Doubles
				sum += Double.parseDouble(number);
			}	
		}
		
		// split the string toAdd on a , delimiter
		
		
		// return their sum
		
		return sum;
	}

}

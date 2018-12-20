package com.revature.example;

public class HelloWorld {
	
	public static void main (String[] args) {
		System.out.println("Hello World");
	
	// create an instance of Calculator
	
	Calculator calc = new Calculator();
	FullName name1 = new FullName();
	
	System.out.println(calc.toString());
	
	System.out.println("Five plus three is: "+calc.add(5,3));
	System.out.println("Eight minus three is : " + calc.subtract(8,3));
	System.out.println("Twelve divided by four is: " + calc.divide(12, 4));
	System.out.println("Five multiplied by three is: " + calc.multiply(5, 3));
	
	System.out.println("My name is: " + name1.name("Cole", "McGrath"));
	String s = "S";
	Double d = Double.parseDouble(s);
	// check type of d, should be parsed as the WRAPPER CLASS double
	// not the primitive double (which is why .getClass() works
	
	System.out.println(d.getClass());
	
	}
	
}

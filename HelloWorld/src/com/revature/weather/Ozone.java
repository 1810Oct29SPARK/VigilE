package com.revature.weather;

public class Ozone extends Stratosphere implements Conditions {

	@Override
	public void sunRadiation() {
		System.out.println("High");
		
	}

	@Override
	public void temperature() {
		System.out.println("Low");
	}

	@Override
	public void moisture() {
		System.out.println("Low");
		
	}

	@Override
	public void airPressure() {
		System.out.println("Low");
		
	}

}

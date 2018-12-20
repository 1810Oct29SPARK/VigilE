package com.revature.vacation;

import com.revature.transport.Boat;

public class Kayak extends Boat {

	public Kayak(String color, double hullLengthInMeters, int numSeats, double paddleLengthInMeters) {
		super(color, hullLengthInMeters);
		this.numSeats = numSeats;
		this.paddleLengthInMeters = paddleLengthInMeters;
		System.out.println("Kayak args constructor completed");
	}

	public Kayak() {
		super();
		System.out.println("Kayak no args constructor completed");
	}

	private int numSeats;
	private double paddleLengthInMeters;

	public int getNumSeats() {
		return numSeats;
	}

	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}

	public double getPaddleLengthInMeters() {
		return paddleLengthInMeters;
	}

	public void setPaddleLengthInMeters(double paddleLengthInMeters) {
		this.paddleLengthInMeters = paddleLengthInMeters;
	}

	@Override
	public String toString() {
		return "Kayak [numSeats=" + numSeats + ", paddleLengthInMeters=" + paddleLengthInMeters + ", color=" + color
				+ ", hullLengthInMeters=" + hullLengthInMeters + "]";
	}

	

}

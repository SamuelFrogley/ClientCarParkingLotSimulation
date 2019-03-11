package com.fdm.parkinglot;

public interface iParkingLot {


	public void vehicleIn(String vehicleType);

	public void vehicleOut(String vehicleType, int hoursParked);

	public int currentSpace();

	public void reportBalance();

	public void decideMethod(String validatedExpression);
}

package com.fdm.parkinglot;

public class ParkingLot implements iParkingLot {

	private ParkingLot parkingLot;
	public int parkingLotSpace;
	public int enteredTrucks;
	public int enteredCars;
	public int exitedTrucks;
	public int exitedCars;
	public double cumulativeFares;

	
	public ParkingLot(int specifiedParkingSpace) {
		parkingLotSpace = specifiedParkingSpace;
	}

	public void vehicleIn(String vehicleType) {
//		
		if (vehicleType.toLowerCase() == "car") {
			if (parkingLotSpace < 1) {
				// return insufficient space exception
			}
			enteredCars++;

		}
		if (vehicleType.toLowerCase() == "truck") {
			if (parkingLotSpace < 2) {
				// return insufficient space exception
			}
			enteredTrucks++;
		}
		// else return invalid vehicle

	}

	public void vehicleOut(String vehicleType, int hoursParked) {
		if (vehicleType.toLowerCase() == "car") {
//			if (parkedCars == 0) {
//				// return no such object exception
//			}
			exitedCars++;
			cumulativeFares = cumulativeFares + (Car.farePerHour * hoursParked);
		}
		if (vehicleType.toLowerCase() == "truck") {
//			if (parkedTrucks == 0) {
//				// return no such object exception
//			}
			exitedTrucks++;
			cumulativeFares = cumulativeFares + (Truck.farePerHour * hoursParked);

		}

	}

	public int currentSpace() {
		return parkingLotSpace - (((enteredTrucks - exitedTrucks) * Truck.parkingSpaceAllocation)
				+ (enteredCars - exitedCars) * Car.parkingSpaceAllocation);
	}

	public void reportBalance() {
		System.out.println("\n Cars Entered: " + enteredCars + "\n Trucks Entered: " + enteredTrucks
				+ "\n Cars Exited: " + exitedCars + "\n Trucks Exited: " + exitedTrucks + "\n Parking Cars: "
				+ (enteredCars - exitedCars) + "\n Parking Trucks: " + (enteredTrucks - exitedTrucks) + "\n Spaces available: "
				+ parkingLotSpace + "\n Fees paid: " + cumulativeFares

		);
	}
	public void decideMethod(String validatedExpression) {
	
	String[] splitArguments = validatedExpression.split("\\s+");

	if (splitArguments[0].toUpperCase() == "ENTER") {
		parkingLot.vehicleIn(splitArguments[1]);

	}
	if (splitArguments[0].toUpperCase() == "EXIT") {
		parkingLot.vehicleOut(splitArguments[1].toLowerCase(), Integer.parseInt(splitArguments[2]));

	}
	if (splitArguments[0].toUpperCase() == "REPORT") {
		parkingLot.reportBalance();

	}
	if (splitArguments[0].matches("\\d")) {
		ParkingLot parkingLot = new ParkingLot(Integer.parseInt(splitArguments[0]));
	}
	if (splitArguments[0].toUpperCase() == "QUIT") {
		System.out.print("/n returning final Parking Lot balance");
		parkingLot.reportBalance();
		System.exit(0);
	}

}
	
}

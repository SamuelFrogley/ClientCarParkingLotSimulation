package com.fdm.parkinglot;

public class ParkingLotDirector {

	private final iValidator ivalidator;
	private final iView iview;
	private iParkingLot iparkingLot;

	public ParkingLotDirector(iView iview, iValidator ivalidator, iParkingLot iparkingLot) {
		this.iview = iview;
		this.ivalidator = ivalidator;
		this.iparkingLot = iparkingLot;

	}

	public void handle() { 
		try {
			String expression = iview.getExpression();
			String validatedExpression = ivalidator.validate(expression);
			iparkingLot.decideMethod(validatedExpression);

		} catch (InvalidCommandException e) {
			iview.display(e.getMessage());
		}
	}

}

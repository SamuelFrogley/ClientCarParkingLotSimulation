package com.fdm.parkinglot;

public class Validator implements iValidator {

	public String validate(String expression) throws InvalidCommandException{
		
		if (expression.isEmpty()) {
			throw new NullPointerException("Error no command input");
		}
			
		if (expression.matches(".*[\\+\\-\\/\\^\\*\\$\\!].*")) {
			throw (new InvalidCommandException("Error: unsupported character in expression"));
		}
		
		if (expression.toUpperCase().contains("ENTER")||
		 (expression.toUpperCase().contains("REPORT"))||
		(expression.toUpperCase().contains("ENTER"))||
		(expression.toUpperCase().contains("EXIT"))||
		(expression.matches("\\d"))){
			return expression;	
		}
		else {
			throw (new InvalidCommandException("Unrecognised command inputed"));
		}
		
		
		
		
		
	
	}
}

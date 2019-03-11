package com.fdm.parkinglot;

public class InvalidCommandException extends Exception {

	private static final long serialVersionUID = 3005186744198373667L;

	public InvalidCommandException(String message) {
		super(message);
	}
}

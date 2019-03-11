package com.fdm.parkinglot;

import java.io.InputStream;
import java.util.Scanner;

public class View implements iView {

	private Scanner scanner;

	void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public String getExpression() {
		if (scanner.hasNextLine()) {
			return scanner.nextLine();
		} else
			return null;

	}

	public void display(String error) {
		System.out.print(error);

	}

}

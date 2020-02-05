package com.zensar.emdb.exception;

public class EnameException extends Exception {
	public String toString() {
		return ("Invalid Employee name!!! Name should be in UpperCase It should contain only 20 or less characters");
	}
}

package com.zensar.emdb.exception;

public class EcodeException extends Exception {
	public String toString() {
		return ("Invalid Employee Code !!! It must be 4 Digit only");
	}
}

package com.zensar.emdb.exception;

public class UserNotFound extends Exception {
	public String toString() {
		return ("\tsUser doesn't exist!!!");
	}
}

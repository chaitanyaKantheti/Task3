package com.own.Task.Task3.exception;

public class Task3Exception extends Exception {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public Task3Exception(String message) {
		super(message);
		this.message = message;
	}

	public Task3Exception() {
		super();

	}

	public Task3Exception(String message, Throwable cause) {
		super(message, cause);
		this.message=message;
	}
}

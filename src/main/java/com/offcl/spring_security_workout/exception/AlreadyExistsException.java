package com.offcl.spring_security_workout.exception;


public class AlreadyExistsException extends RuntimeException {
	public AlreadyExistsException(String message){
		super(message);
	}
}

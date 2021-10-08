package com.springrest.springrest.exception;

public class EmployeesDataNotFoundException extends RuntimeException {
	
    private String message;

    public EmployeesDataNotFoundException(String message) {
        super(message);
        this.message = message;
    }

}
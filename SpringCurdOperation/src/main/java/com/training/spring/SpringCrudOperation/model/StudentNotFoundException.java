package com.training.spring.SpringCrudOperation.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class StudentNotFoundException extends RuntimeException {
	public StudentNotFoundException(String exception) {
		super(exception);
	}
	
	public StudentNotFoundException(String exception,Throwable t) {
		super(exception,t);
	}
}

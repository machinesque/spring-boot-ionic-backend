package com.udemy.cursomc.services.exceptions;

public class DataIntegrityException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public DataIntegrityException(String message) {
		super(message);
	}
	
	public DataIntegrityException(String message, Throwable cause) {
		super(message, cause);
	}
	
}

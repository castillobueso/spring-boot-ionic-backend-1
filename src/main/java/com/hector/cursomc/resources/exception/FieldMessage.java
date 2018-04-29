package com.hector.cursomc.resources.exception;

import java.io.Serializable;

public class FieldMessage  implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	private String fieldName;
	private String message;

	// Constructor Vacio
	public FieldMessage() {		
	}

	// Constructor con Argumentos
	public FieldMessage(String fieldName, String message) {
		super();
		this.fieldName = fieldName;
		this.message = message;
	}

	// Getters y Setters
	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

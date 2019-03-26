package com.edigiseva.message.request;

import org.springframework.http.HttpStatus;

public class DigiSevaResponseEntity {

	private HttpStatus responseCode;
	private Object value;
	private boolean isError;
	private String message;
	
	public HttpStatus getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(HttpStatus responseCode) {
		this.responseCode = responseCode;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public boolean isError() {
		return isError;
	}
	public void setError(boolean isError) {
		this.isError = isError;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public DigiSevaResponseEntity(HttpStatus responseCode, Object value, boolean isError, String message) {
		super();
		this.responseCode = responseCode;
		this.value = value;
		this.isError = isError;
		this.message = message;
	}
	public DigiSevaResponseEntity() {
		super();
	}
}

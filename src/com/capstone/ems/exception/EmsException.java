package com.capstone.ems.exception;

public class EmsException extends Exception{

	private String errorCode;
	private int errorCodeNumber;

	
	public String getErrorCode() {
		return errorCode;
	}

	public EmsException(String errorCode) {
		super();
		this.errorCode = errorCode;
	}
	
	public EmsException(String message, Throwable cause, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}
	
	public EmsException(String message, Throwable cause) {
		super(message);
	}
	
	
	public EmsException(String message,  String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}
	
	public EmsException(Throwable cause,  String errorCode) {
		super(cause);
		this.errorCode = errorCode;
	}
	
	public EmsException(String message,  int errorCode) {
		super(message);
		this.errorCodeNumber = errorCode;
	}
}

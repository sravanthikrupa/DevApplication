package com.app.dca.exception;

public class UnknownFeedException extends Exception{

     private int id;
	
	public UnknownFeedException(int id) {
		super();
		this.id = id;
	}
	

	public UnknownFeedException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UnknownFeedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UnknownFeedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UnknownFeedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UnknownFeedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}

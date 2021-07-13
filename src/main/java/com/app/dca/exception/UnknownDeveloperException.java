package com.app.dca.exception;

public class UnknownDeveloperException extends Exception {

    private int id;
	
	public UnknownDeveloperException(int id) {
		super();
		this.id = id;
	}

	public UnknownDeveloperException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UnknownDeveloperException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UnknownDeveloperException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UnknownDeveloperException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UnknownDeveloperException(Throwable cause) {
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

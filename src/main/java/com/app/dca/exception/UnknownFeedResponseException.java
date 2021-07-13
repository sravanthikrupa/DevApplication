package com.app.dca.exception;

public class UnknownFeedResponseException extends Exception {
    private int id;
    
	public UnknownFeedResponseException(int id) {
		super();
		this.id = id;
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public UnknownFeedResponseException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UnknownFeedResponseException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UnknownFeedResponseException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UnknownFeedResponseException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UnknownFeedResponseException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
   
}

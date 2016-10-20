package com.bizruntime.dao.companyservicelayer.test;
public class ConnectionFail extends Exception{

	public ConnectionFail() {
		super();
	}

	public ConnectionFail(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ConnectionFail(String message, Throwable cause) {
		super(message, cause);
	}

	public ConnectionFail(String message) {
		super(message);
	}

	public ConnectionFail(Throwable cause) {
		super(cause);
	}

}

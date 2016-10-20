package com.bizruntime.dao.persistence.impl;
public class SqlExceptionFound extends Exception
{

	public SqlExceptionFound() {
		super();
	}

	public SqlExceptionFound(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SqlExceptionFound(String message, Throwable cause) {
		super(message, cause);
	}

	public SqlExceptionFound(String message) {
		super(message);
	}

	public SqlExceptionFound(Throwable cause) {
		super(cause);
	}

}

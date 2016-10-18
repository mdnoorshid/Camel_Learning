package com.bizruntime.util;

public class FileNotFoundExc extends Exception
{

	public FileNotFoundExc() {
		super();
	}

	public FileNotFoundExc(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FileNotFoundExc(String message, Throwable cause) {
		super(message, cause);
	}

	public FileNotFoundExc(String message) {
		super(message);
	}

	public FileNotFoundExc(Throwable cause) {
		super(cause);
	}

}

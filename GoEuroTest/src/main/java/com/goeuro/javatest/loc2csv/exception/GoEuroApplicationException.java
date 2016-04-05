package com.goeuro.javatest.loc2csv.exception;

public class GoEuroApplicationException extends Exception {

    private static final long serialVersionUID = 3537340728732854093L;

    public GoEuroApplicationException() {
	super();
    }

    public GoEuroApplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
	super(message, cause, enableSuppression, writableStackTrace);
    }

    public GoEuroApplicationException(Throwable cause, String message) {
	super(message, cause);
    }

    public GoEuroApplicationException(String message) {
	super(message);
    }

    public GoEuroApplicationException(Throwable cause) {
	super(cause);
    }

}

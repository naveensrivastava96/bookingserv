package com.paypal.bfs.test.bookingserv.exceptionhandler;

public class BookingSerException extends RuntimeException{
    public BookingSerException() {
        super();
    }

    public BookingSerException(String message) {
        super(message);
    }

    public BookingSerException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookingSerException(Throwable cause) {
        super(cause);
    }

    protected BookingSerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

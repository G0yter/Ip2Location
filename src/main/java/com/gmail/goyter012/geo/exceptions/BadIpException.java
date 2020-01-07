package com.gmail.goyter012.geo.exceptions;

public class BadIpException extends RuntimeException{

    public BadIpException() {
        super();
    }

    public BadIpException(String s) {
        super(s);
    }

    public BadIpException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public BadIpException(Throwable throwable) {
        super(throwable);
    }
}

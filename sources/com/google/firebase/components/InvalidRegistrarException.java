package com.google.firebase.components;

public class InvalidRegistrarException extends RuntimeException {
    public InvalidRegistrarException(String str) {
        super(str);
    }

    public InvalidRegistrarException(String str, Throwable th2) {
        super(str, th2);
    }
}

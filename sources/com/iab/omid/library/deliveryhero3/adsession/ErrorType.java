package com.iab.omid.library.deliveryhero3.adsession;

public enum ErrorType {
    GENERIC("generic"),
    VIDEO("video");
    
    private final String errorType;

    private ErrorType(String str) {
        this.errorType = str;
    }

    public String toString() {
        return this.errorType;
    }
}

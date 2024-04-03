package com.instabug.library.model.session;

public class NullSessionException extends Exception {
    public NullSessionException() {
    }

    public NullSessionException(String str) {
        super(str);
    }
}

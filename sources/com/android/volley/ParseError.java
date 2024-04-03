package com.android.volley;

public class ParseError extends VolleyError {
    public ParseError() {
    }

    public ParseError(NetworkResponse networkResponse) {
        super(networkResponse);
    }

    public ParseError(Throwable th2) {
        super(th2);
    }
}

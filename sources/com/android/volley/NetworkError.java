package com.android.volley;

public class NetworkError extends VolleyError {
    public NetworkError() {
    }

    public NetworkError(Throwable th2) {
        super(th2);
    }

    public NetworkError(NetworkResponse networkResponse) {
        super(networkResponse);
    }
}

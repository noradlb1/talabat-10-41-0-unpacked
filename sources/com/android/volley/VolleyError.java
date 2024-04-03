package com.android.volley;

public class VolleyError extends Exception {
    public final NetworkResponse networkResponse;
    private long networkTimeMs;

    public VolleyError() {
        this.networkResponse = null;
    }

    public long getNetworkTimeMs() {
        return this.networkTimeMs;
    }

    public void setNetworkTimeMs(long j11) {
        this.networkTimeMs = j11;
    }

    public VolleyError(NetworkResponse networkResponse2) {
        this.networkResponse = networkResponse2;
    }

    public VolleyError(String str) {
        super(str);
        this.networkResponse = null;
    }

    public VolleyError(String str, Throwable th2) {
        super(str, th2);
        this.networkResponse = null;
    }

    public VolleyError(Throwable th2) {
        super(th2);
        this.networkResponse = null;
    }
}

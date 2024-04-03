package com.huawei.agconnect.https;

import java.io.IOException;

public class HttpsException extends Exception {

    /* renamed from: e  reason: collision with root package name */
    private final IOException f47622e;
    private final boolean hasRequest;

    public HttpsException(boolean z11, IOException iOException) {
        super(getMessage(z11, iOException));
        this.hasRequest = z11;
        this.f47622e = iOException;
    }

    public HttpsException(boolean z11, String str) {
        super(str);
        this.hasRequest = z11;
        this.f47622e = new IOException(str);
    }

    private static String getMessage(boolean z11, IOException iOException) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("HTTP HasRequest: ");
        sb2.append(z11);
        sb2.append(" ");
        sb2.append(iOException == null ? "" : iOException.getMessage());
        return sb2.toString();
    }

    public IOException getException() {
        return this.f47622e;
    }

    public boolean hasRequest() {
        return this.hasRequest;
    }

    public String message() {
        IOException iOException = this.f47622e;
        return iOException == null ? "exception is null" : iOException.getMessage();
    }
}

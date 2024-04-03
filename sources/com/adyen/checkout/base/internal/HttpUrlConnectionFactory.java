package com.adyen.checkout.base.internal;

import androidx.annotation.NonNull;
import java.net.HttpURLConnection;

class HttpUrlConnectionFactory extends BaseHttpUrlConnectionFactory {
    @NonNull
    public HttpURLConnection b(@NonNull HttpURLConnection httpURLConnection) {
        throw new RuntimeException("Trying to connect to a URL that is not HTTPS.");
    }
}

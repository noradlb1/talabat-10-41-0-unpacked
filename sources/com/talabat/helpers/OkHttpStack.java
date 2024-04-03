package com.talabat.helpers;

import com.android.volley.toolbox.HurlStack;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import okhttp3.OkHttpClient;

public class OkHttpStack extends HurlStack {
    private final OkHttpClient client;

    public OkHttpStack() {
        this(new OkHttpClient());
    }

    public HttpURLConnection createConnection(URL url) throws IOException {
        return new ObsoleteUrlFactory(this.client).open(url);
    }

    public OkHttpStack(OkHttpClient okHttpClient) {
        if (okHttpClient != null) {
            this.client = okHttpClient;
            return;
        }
        throw new NullPointerException("Client must not be null.");
    }
}

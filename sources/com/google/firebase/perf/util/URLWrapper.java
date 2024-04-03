package com.google.firebase.perf.util;

import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

@Instrumented
public class URLWrapper {
    private final URL url;

    public URLWrapper(URL url2) {
        this.url = url2;
    }

    public URLConnection openConnection() throws IOException {
        return URLConnectionInstrumentation.openConnection(this.url.openConnection());
    }

    public String toString() {
        return this.url.toString();
    }
}

package com.instabug.apm.networkinterception;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

@Instrumented
public class URLConnectionHandler {
    public static URLConnection openConnection(URL url) {
        URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(URLConnectionInstrumentation.openConnection(url.openConnection()));
        return uRLConnection instanceof HttpsURLConnection ? new b((HttpsURLConnection) uRLConnection) : uRLConnection instanceof HttpURLConnection ? new a((HttpURLConnection) uRLConnection) : uRLConnection;
    }
}

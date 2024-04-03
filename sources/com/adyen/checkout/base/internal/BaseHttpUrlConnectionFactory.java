package com.adyen.checkout.base.internal;

import androidx.annotation.NonNull;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

@Instrumented
public abstract class BaseHttpUrlConnectionFactory {
    private static final SSLSocketFactory SSL_SOCKET_FACTORY;

    static {
        try {
            SSL_SOCKET_FACTORY = new TlsSocketFactory();
        } catch (KeyManagementException | NoSuchAlgorithmException unused) {
            throw new RuntimeException("Could not initialize SSLSocketFactory.");
        }
    }

    @NonNull
    public HttpURLConnection a(@NonNull String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(URLConnectionInstrumentation.openConnection(new URL(str).openConnection())));
        if (!(httpURLConnection instanceof HttpsURLConnection)) {
            return b(httpURLConnection);
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
        httpsURLConnection.setSSLSocketFactory(SSL_SOCKET_FACTORY);
        return httpsURLConnection;
    }

    @NonNull
    public abstract HttpURLConnection b(@NonNull HttpURLConnection httpURLConnection);
}

package com.newrelic.agent.android.instrumentation;

import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

public final class URLConnectionInstrumentation {
    private URLConnectionInstrumentation() {
    }

    public static void httpClientError(TransactionState transactionState, Exception exc) {
        if (!transactionState.isComplete()) {
            TransactionStateUtil.setErrorCodeFromException(transactionState, exc);
            TransactionData end = transactionState.end();
            if (end != null) {
                end.setResponseBody(exc.toString());
                TaskQueue.queue(new HttpTransactionMeasurement(end));
            }
        }
    }

    @WrapReturn(className = "java/net/URL", methodDesc = "()Ljava/net/URLConnection;", methodName = "openConnection")
    public static URLConnection openConnection(URLConnection uRLConnection) {
        if (uRLConnection instanceof HttpsURLConnection) {
            return new HttpsURLConnectionExtension((HttpsURLConnection) uRLConnection);
        }
        if (uRLConnection instanceof HttpURLConnection) {
            return new HttpURLConnectionExtension((HttpURLConnection) uRLConnection);
        }
        return uRLConnection;
    }

    @WrapReturn(className = "java/net/URL", methodDesc = "(Ljava/net/Proxy;)Ljava/net/URLConnection;", methodName = "openConnection")
    public static URLConnection openConnectionWithProxy(URLConnection uRLConnection) {
        if (uRLConnection instanceof HttpsURLConnection) {
            return new HttpsURLConnectionExtension((HttpsURLConnection) uRLConnection);
        }
        if (uRLConnection instanceof HttpURLConnection) {
            return new HttpURLConnectionExtension((HttpURLConnection) uRLConnection);
        }
        return uRLConnection;
    }
}

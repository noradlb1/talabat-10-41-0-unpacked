package com.google.android.gms.internal.gtm;

import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@Instrumented
final class zzfv implements zzfx {
    public final HttpURLConnection zzc(URL url) throws IOException {
        return (HttpURLConnection) URLConnectionInstrumentation.openConnection(url.openConnection());
    }
}

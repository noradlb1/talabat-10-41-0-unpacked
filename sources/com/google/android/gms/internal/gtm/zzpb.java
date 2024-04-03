package com.google.android.gms.internal.gtm;

import com.google.android.gms.tagmanager.zzdi;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Instrumented
final class zzpb implements zzpc {
    private HttpURLConnection zzatk;
    private InputStream zzatl = null;

    public final void close() {
        String str;
        HttpURLConnection httpURLConnection = this.zzatk;
        try {
            InputStream inputStream = this.zzatl;
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e11) {
            String valueOf = String.valueOf(e11.getMessage());
            if (valueOf.length() != 0) {
                str = "HttpUrlConnectionNetworkClient: Error when closing http input stream: ".concat(valueOf);
            } else {
                str = new String("HttpUrlConnectionNetworkClient: Error when closing http input stream: ");
            }
            zzdi.zza(str, e11);
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    public final InputStream zzcj(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) URLConnectionInstrumentation.openConnection(new URL(str).openConnection());
        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.setConnectTimeout(20000);
        this.zzatk = httpURLConnection;
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 200) {
            InputStream inputStream = httpURLConnection.getInputStream();
            this.zzatl = inputStream;
            return inputStream;
        }
        StringBuilder sb2 = new StringBuilder(25);
        sb2.append("Bad response: ");
        sb2.append(responseCode);
        String sb3 = sb2.toString();
        if (responseCode == 404) {
            throw new FileNotFoundException(sb3);
        } else if (responseCode == 503) {
            throw new zzpe(sb3);
        } else {
            throw new IOException(sb3);
        }
    }
}

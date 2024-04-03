package com.huawei.hms.framework.network.grs.h.f;

import android.content.Context;
import android.text.TextUtils;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

@Instrumented
public class a {
    public static HttpsURLConnection a(String str, Context context, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        URLConnection uRLConnection = (URLConnection) FirebasePerfUrlConnection.instrument(URLConnectionInstrumentation.openConnection(new URL(str).openConnection()));
        if (uRLConnection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) uRLConnection;
            try {
                httpsURLConnection.setSSLSocketFactory(com.huawei.hms.framework.network.grs.h.g.a.a(context));
                httpsURLConnection.setHostnameVerifier(com.huawei.hms.framework.network.grs.h.g.a.a());
            } catch (IllegalArgumentException unused) {
                Logger.w("URLConnectionHelper", "init https ssl socket failed.");
            }
            httpsURLConnection.setConnectTimeout(10000);
            httpsURLConnection.setReadTimeout(10000);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setUseCaches(false);
            String b11 = com.huawei.hms.framework.network.grs.h.a.b(context, "NetworkKit-grs", str2);
            Logger.d("URLConnectionHelper", "request to grs server with a User-Agent header is: " + b11);
            httpsURLConnection.setRequestProperty("User-Agent", b11);
            return httpsURLConnection;
        }
        Logger.w("URLConnectionHelper", "urlConnection is not an instance of HttpsURLConnection");
        return null;
    }

    public static void a(HttpsURLConnection httpsURLConnection, String str) {
        OutputStream outputStream;
        String str2;
        if (str == null) {
            str2 = "sendHttpBody: The Body Data is Null";
        } else if (httpsURLConnection == null) {
            str2 = "sendHttpBody: HttpsURLConnection is Null";
        } else {
            try {
                outputStream = httpsURLConnection.getOutputStream();
                try {
                    outputStream.write(str.getBytes("UTF-8"));
                    outputStream.flush();
                    IoUtils.closeSecure(outputStream);
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    IoUtils.closeSecure(outputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                outputStream = null;
                IoUtils.closeSecure(outputStream);
                throw th;
            }
        }
        Logger.i("URLConnectionHelper", str2);
    }
}

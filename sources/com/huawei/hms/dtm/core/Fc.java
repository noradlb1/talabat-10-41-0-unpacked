package com.huawei.hms.dtm.core;

import androidx.webkit.ProxyConfig;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.huawei.hms.dtm.core.util.Logger;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

@Instrumented
public final class Fc {
    public static Hc a(Gc gc2) {
        HttpURLConnection b11 = b(gc2);
        if (b11 != null) {
            return a(b11);
        }
        Hc hc2 = new Hc();
        hc2.a(-1);
        hc2.b("open connection error.");
        return hc2;
    }

    public static Hc a(String str) {
        URL b11 = b(str);
        if (b11 == null) {
            Hc hc2 = new Hc();
            hc2.a(-1);
            hc2.b("url is null");
            return hc2;
        }
        Gc gc2 = new Gc();
        gc2.a(b11);
        gc2.b("GET");
        return a(gc2);
    }

    private static Hc a(HttpURLConnection httpURLConnection) {
        Hc hc2 = new Hc();
        int b11 = b(httpURLConnection);
        hc2.a(b11);
        hc2.b(c(httpURLConnection));
        for (Map.Entry next : httpURLConnection.getHeaderFields().entrySet()) {
            if (next.getKey() != null) {
                hc2.a((String) next.getKey(), String.valueOf(next.getValue()));
            }
        }
        hc2.a(a(httpURLConnection, b11));
        httpURLConnection.disconnect();
        return hc2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(java.net.HttpURLConnection r5, int r6) {
        /*
            r0 = 404(0x194, float:5.66E-43)
            java.lang.String r1 = "http"
            r2 = 0
            if (r6 != r0) goto L_0x000c
            java.io.InputStream r5 = r5.getErrorStream()     // Catch:{ IOException -> 0x0041, all -> 0x003d }
            goto L_0x0010
        L_0x000c:
            java.io.InputStream r5 = r5.getInputStream()     // Catch:{ IOException -> 0x0041, all -> 0x003d }
        L_0x0010:
            if (r5 != 0) goto L_0x0019
            com.huawei.hms.dtm.core.util.k.a(r1, r2)
            com.huawei.hms.dtm.core.util.k.a(r1, r5)
            return r2
        L_0x0019:
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x003b, all -> 0x0038 }
            r6.<init>()     // Catch:{ IOException -> 0x003b, all -> 0x0038 }
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]     // Catch:{ IOException -> 0x0043 }
        L_0x0022:
            int r3 = r5.read(r0)     // Catch:{ IOException -> 0x0043 }
            r4 = -1
            if (r3 == r4) goto L_0x002e
            r4 = 0
            r6.write(r0, r4, r3)     // Catch:{ IOException -> 0x0043 }
            goto L_0x0022
        L_0x002e:
            r6.flush()     // Catch:{ IOException -> 0x0043 }
            java.lang.String r0 = "UTF-8"
            java.lang.String r2 = r6.toString(r0)     // Catch:{ IOException -> 0x0043 }
            goto L_0x0048
        L_0x0038:
            r6 = move-exception
            r0 = r6
            goto L_0x0051
        L_0x003b:
            r6 = r2
            goto L_0x0043
        L_0x003d:
            r5 = move-exception
            r0 = r5
            r5 = r2
            goto L_0x0051
        L_0x0041:
            r5 = r2
            r6 = r5
        L_0x0043:
            java.lang.String r0 = "read data from http response failed"
            com.huawei.hms.dtm.core.util.Logger.error(r0)     // Catch:{ all -> 0x004f }
        L_0x0048:
            com.huawei.hms.dtm.core.util.k.a(r1, r6)
            com.huawei.hms.dtm.core.util.k.a(r1, r5)
            return r2
        L_0x004f:
            r0 = move-exception
            r2 = r6
        L_0x0051:
            com.huawei.hms.dtm.core.util.k.a(r1, r2)
            com.huawei.hms.dtm.core.util.k.a(r1, r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.dtm.core.Fc.a(java.net.HttpURLConnection, int):java.lang.String");
    }

    private static HttpURLConnection a(URL url) {
        HttpURLConnection httpURLConnection;
        String url2 = url.toString();
        if (url2.startsWith(ProxyConfig.MATCH_HTTP) || url2.startsWith("https")) {
            try {
                httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(URLConnectionInstrumentation.openConnection(url.openConnection())));
                try {
                    if (httpURLConnection instanceof HttpsURLConnection) {
                        ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(Ic.a());
                    }
                } catch (IOException unused) {
                    Logger.error("open http connection failed");
                    return httpURLConnection;
                }
            } catch (IOException unused2) {
                httpURLConnection = null;
                Logger.error("open http connection failed");
                return httpURLConnection;
            }
            return httpURLConnection;
        }
        throw new V("url format is wrong!");
    }

    private static void a(HttpURLConnection httpURLConnection, String str) {
        try {
            httpURLConnection.setRequestMethod(str);
        } catch (ProtocolException unused) {
            Logger.error("HttpUtil", "setRequestMethod fail.");
        }
    }

    private static void a(HttpURLConnection httpURLConnection, String str, String str2) {
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setUseCaches(false);
        b(httpURLConnection, str, str2);
    }

    private static int b(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException unused) {
            Logger.error("HttpUtil", "getResponseCode fail.");
            return 0;
        }
    }

    private static HttpURLConnection b(Gc gc2) {
        HttpURLConnection a11 = a(gc2.d());
        if (a11 == null) {
            return null;
        }
        a11.setConnectTimeout(10000);
        a11.setReadTimeout(10000);
        a(a11, gc2.c());
        String str = "";
        for (String next : gc2.b().keySet()) {
            a11.setRequestProperty(next, gc2.b().get(next));
            if ("charset".equalsIgnoreCase(next)) {
                str = gc2.b().get(next);
            }
        }
        String c11 = gc2.c();
        c11.hashCode();
        if (c11.equals("POST")) {
            a(a11, gc2.a(), str);
        } else if (c11.equals("GET")) {
            d(a11);
        }
        return a11;
    }

    private static URL b(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException unused) {
            Logger.error("HttpUtil", "createURL fail.");
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0007, code lost:
        if (r4.length() == 0) goto L_0x0009;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(java.net.HttpURLConnection r2, java.lang.String r3, java.lang.String r4) {
        /*
            r0 = 0
            if (r4 == 0) goto L_0x0009
            int r1 = r4.length()     // Catch:{ IOException -> 0x0023 }
            if (r1 != 0) goto L_0x000b
        L_0x0009:
            java.lang.String r4 = "UTF-8"
        L_0x000b:
            java.io.OutputStreamWriter r1 = new java.io.OutputStreamWriter     // Catch:{ IOException -> 0x0023 }
            java.io.OutputStream r2 = r2.getOutputStream()     // Catch:{ IOException -> 0x0023 }
            r1.<init>(r2, r4)     // Catch:{ IOException -> 0x0023 }
            if (r3 != 0) goto L_0x0018
            java.lang.String r3 = ""
        L_0x0018:
            r1.write(r3)     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            r1.flush()     // Catch:{ IOException -> 0x0022, all -> 0x001f }
            goto L_0x002b
        L_0x001f:
            r2 = move-exception
            r0 = r1
            goto L_0x0030
        L_0x0022:
            r0 = r1
        L_0x0023:
            java.lang.String r2 = "HttpUtil"
            java.lang.String r3 = "writeData fail."
            com.huawei.hms.dtm.core.util.Logger.error(r2, r3)     // Catch:{ all -> 0x002f }
            r1 = r0
        L_0x002b:
            com.huawei.hms.dtm.core.util.k.a(r1)
            return
        L_0x002f:
            r2 = move-exception
        L_0x0030:
            com.huawei.hms.dtm.core.util.k.a(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.dtm.core.Fc.b(java.net.HttpURLConnection, java.lang.String, java.lang.String):void");
    }

    private static String c(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseMessage();
        } catch (IOException e11) {
            String message = e11.getMessage();
            Logger.error("HttpUtil", "getResponseCode fail.");
            return message;
        }
    }

    private static void d(HttpURLConnection httpURLConnection) {
        try {
            httpURLConnection.connect();
        } catch (IOException unused) {
            Logger.error("HttpUtil", "connect fail.");
        }
    }
}

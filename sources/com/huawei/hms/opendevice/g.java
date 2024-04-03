package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation;
import com.talabat.helpers.TalabatVolley;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Map;

@Instrumented
public abstract class g {

    public enum a {
        GET("GET"),
        POST("POST");
        

        /* renamed from: a  reason: collision with root package name */
        private String f49648a;

        private a(String str) {
            this.f49648a = str;
        }

        public String a() {
            return this.f49648a;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.io.BufferedInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v22, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v23, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v27, resolved type: java.io.BufferedOutputStream} */
    /* JADX WARNING: type inference failed for: r8v1, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r8v3 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00ae */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r7, java.lang.String r8, java.lang.String r9, java.util.Map<java.lang.String, java.lang.String> r10) {
        /*
            java.lang.String r0 = "close connection"
            java.lang.String r1 = "PushHttpClient"
            r2 = 0
            if (r9 == 0) goto L_0x011e
            boolean r3 = android.text.TextUtils.isEmpty(r8)
            if (r3 != 0) goto L_0x011e
            boolean r3 = android.text.TextUtils.isEmpty(r9)
            if (r3 == 0) goto L_0x0015
            goto L_0x011e
        L_0x0015:
            r3 = -1
            com.huawei.hms.opendevice.g$a r4 = com.huawei.hms.opendevice.g.a.POST     // Catch:{ IOException -> 0x00dc, RuntimeException -> 0x00c3, Exception -> 0x00aa, all -> 0x00a4 }
            java.lang.String r4 = r4.a()     // Catch:{ IOException -> 0x00dc, RuntimeException -> 0x00c3, Exception -> 0x00aa, all -> 0x00a4 }
            java.net.HttpURLConnection r7 = a((android.content.Context) r7, (java.lang.String) r8, (java.util.Map<java.lang.String, java.lang.String>) r10, (java.lang.String) r4)     // Catch:{ IOException -> 0x00dc, RuntimeException -> 0x00c3, Exception -> 0x00aa, all -> 0x00a4 }
            if (r7 != 0) goto L_0x0032
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.OutputStream) r2)
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.InputStream) r2)
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.InputStream) r2)
            com.huawei.hms.opendevice.p.a((java.net.HttpURLConnection) r7)
            com.huawei.hms.support.log.HMSLog.i(r1, r0)
            return r2
        L_0x0032:
            java.io.BufferedOutputStream r8 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x00dd, RuntimeException -> 0x00c4, Exception -> 0x00ab, all -> 0x009c }
            java.io.OutputStream r10 = r7.getOutputStream()     // Catch:{ IOException -> 0x00dd, RuntimeException -> 0x00c4, Exception -> 0x00ab, all -> 0x009c }
            r8.<init>(r10)     // Catch:{ IOException -> 0x00dd, RuntimeException -> 0x00c4, Exception -> 0x00ab, all -> 0x009c }
            java.lang.String r10 = "UTF-8"
            byte[] r9 = r9.getBytes(r10)     // Catch:{ IOException -> 0x0099, RuntimeException -> 0x0096, Exception -> 0x0093, all -> 0x008e }
            r8.write(r9)     // Catch:{ IOException -> 0x0099, RuntimeException -> 0x0096, Exception -> 0x0093, all -> 0x008e }
            r8.flush()     // Catch:{ IOException -> 0x0099, RuntimeException -> 0x0096, Exception -> 0x0093, all -> 0x008e }
            int r3 = r7.getResponseCode()     // Catch:{ IOException -> 0x0099, RuntimeException -> 0x0096, Exception -> 0x0093, all -> 0x008e }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0099, RuntimeException -> 0x0096, Exception -> 0x0093, all -> 0x008e }
            r9.<init>()     // Catch:{ IOException -> 0x0099, RuntimeException -> 0x0096, Exception -> 0x0093, all -> 0x008e }
            java.lang.String r10 = "http post response code: "
            r9.append(r10)     // Catch:{ IOException -> 0x0099, RuntimeException -> 0x0096, Exception -> 0x0093, all -> 0x008e }
            r9.append(r3)     // Catch:{ IOException -> 0x0099, RuntimeException -> 0x0096, Exception -> 0x0093, all -> 0x008e }
            java.lang.String r9 = r9.toString()     // Catch:{ IOException -> 0x0099, RuntimeException -> 0x0096, Exception -> 0x0093, all -> 0x008e }
            com.huawei.hms.support.log.HMSLog.d(r1, r9)     // Catch:{ IOException -> 0x0099, RuntimeException -> 0x0096, Exception -> 0x0093, all -> 0x008e }
            r9 = 400(0x190, float:5.6E-43)
            if (r3 < r9) goto L_0x0068
            java.io.InputStream r9 = r7.getErrorStream()     // Catch:{ IOException -> 0x0099, RuntimeException -> 0x0096, Exception -> 0x0093, all -> 0x008e }
            goto L_0x006c
        L_0x0068:
            java.io.InputStream r9 = r7.getInputStream()     // Catch:{ IOException -> 0x0099, RuntimeException -> 0x0096, Exception -> 0x0093, all -> 0x008e }
        L_0x006c:
            java.io.BufferedInputStream r10 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x009a, RuntimeException -> 0x0097, Exception -> 0x0094, all -> 0x008b }
            r10.<init>(r9)     // Catch:{ IOException -> 0x009a, RuntimeException -> 0x0097, Exception -> 0x0094, all -> 0x008b }
            java.lang.String r2 = com.huawei.hms.opendevice.p.a((java.io.InputStream) r10)     // Catch:{ IOException -> 0x00e0, RuntimeException -> 0x00c7, Exception -> 0x00ae, all -> 0x0085 }
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.OutputStream) r8)
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.InputStream) r9)
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.InputStream) r10)
            com.huawei.hms.opendevice.p.a((java.net.HttpURLConnection) r7)
            com.huawei.hms.support.log.HMSLog.i(r1, r0)
            return r2
        L_0x0085:
            r2 = move-exception
            r6 = r2
            r2 = r10
            r10 = r6
            goto L_0x010e
        L_0x008b:
            r10 = move-exception
            goto L_0x010e
        L_0x008e:
            r9 = move-exception
            r10 = r9
            r9 = r2
            goto L_0x010e
        L_0x0093:
            r9 = r2
        L_0x0094:
            r10 = r2
            goto L_0x00ae
        L_0x0096:
            r9 = r2
        L_0x0097:
            r10 = r2
            goto L_0x00c7
        L_0x0099:
            r9 = r2
        L_0x009a:
            r10 = r2
            goto L_0x00e0
        L_0x009c:
            r8 = move-exception
            r9 = r2
            r10 = r9
            r6 = r8
            r8 = r7
            r7 = r6
            goto L_0x0109
        L_0x00a4:
            r7 = move-exception
            r8 = r2
            r9 = r8
            r10 = r9
            goto L_0x0109
        L_0x00aa:
            r7 = r2
        L_0x00ab:
            r8 = r2
            r9 = r8
            r10 = r9
        L_0x00ae:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0104 }
            r4.<init>()     // Catch:{ all -> 0x0104 }
            java.lang.String r5 = "http execute encounter unknown exception - http code:"
            r4.append(r5)     // Catch:{ all -> 0x0104 }
            r4.append(r3)     // Catch:{ all -> 0x0104 }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0104 }
            com.huawei.hms.support.log.HMSLog.w(r1, r3)     // Catch:{ all -> 0x0104 }
            goto L_0x00f4
        L_0x00c3:
            r7 = r2
        L_0x00c4:
            r8 = r2
            r9 = r8
            r10 = r9
        L_0x00c7:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0104 }
            r4.<init>()     // Catch:{ all -> 0x0104 }
            java.lang.String r5 = "http execute encounter RuntimeException - http code:"
            r4.append(r5)     // Catch:{ all -> 0x0104 }
            r4.append(r3)     // Catch:{ all -> 0x0104 }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0104 }
            com.huawei.hms.support.log.HMSLog.w(r1, r3)     // Catch:{ all -> 0x0104 }
            goto L_0x00f4
        L_0x00dc:
            r7 = r2
        L_0x00dd:
            r8 = r2
            r9 = r8
            r10 = r9
        L_0x00e0:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0104 }
            r4.<init>()     // Catch:{ all -> 0x0104 }
            java.lang.String r5 = "http execute encounter IOException - http code:"
            r4.append(r5)     // Catch:{ all -> 0x0104 }
            r4.append(r3)     // Catch:{ all -> 0x0104 }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0104 }
            com.huawei.hms.support.log.HMSLog.w(r1, r3)     // Catch:{ all -> 0x0104 }
        L_0x00f4:
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.OutputStream) r8)
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.InputStream) r9)
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.InputStream) r10)
            com.huawei.hms.opendevice.p.a((java.net.HttpURLConnection) r7)
            com.huawei.hms.support.log.HMSLog.i(r1, r0)
            return r2
        L_0x0104:
            r2 = move-exception
            r6 = r8
            r8 = r7
            r7 = r2
            r2 = r6
        L_0x0109:
            r6 = r10
            r10 = r7
            r7 = r8
            r8 = r2
            r2 = r6
        L_0x010e:
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.OutputStream) r8)
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.InputStream) r9)
            com.huawei.secure.android.common.util.IOUtil.closeSecure((java.io.InputStream) r2)
            com.huawei.hms.opendevice.p.a((java.net.HttpURLConnection) r7)
            com.huawei.hms.support.log.HMSLog.i(r1, r0)
            throw r10
        L_0x011e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.opendevice.g.a(android.content.Context, java.lang.String, java.lang.String, java.util.Map):java.lang.String");
    }

    private static HttpURLConnection a(Context context, String str, Map<String, String> map, String str2) throws Exception {
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(URLConnectionInstrumentation.openConnection(new URL(str).openConnection())));
        a(context, httpURLConnection);
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setConnectTimeout(TalabatVolley.DEFAULT_TIMEOUT_MS);
        httpURLConnection.setReadTimeout(TalabatVolley.DEFAULT_TIMEOUT_MS);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestProperty("Content-type", "application/json; charset=UTF-8");
        httpURLConnection.setRequestProperty("Connection", "close");
        if (map != null && map.size() >= 1) {
            for (Map.Entry next : map.entrySet()) {
                String str3 = (String) next.getKey();
                if (str3 != null && !TextUtils.isEmpty(str3)) {
                    httpURLConnection.setRequestProperty(str3, URLEncoder.encode(next.getValue() == null ? "" : (String) next.getValue(), "UTF-8"));
                }
            }
        }
        return httpURLConnection;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(android.content.Context r2, java.net.HttpURLConnection r3) throws java.lang.Exception {
        /*
            java.lang.String r0 = "PushHttpClient"
            boolean r1 = r3 instanceof javax.net.ssl.HttpsURLConnection
            if (r1 == 0) goto L_0x0044
            javax.net.ssl.HttpsURLConnection r3 = (javax.net.ssl.HttpsURLConnection) r3
            com.huawei.secure.android.common.ssl.SecureSSLSocketFactory r2 = com.huawei.secure.android.common.ssl.SecureSSLSocketFactory.getInstance(r2)     // Catch:{ NoSuchAlgorithmException -> 0x002b, KeyStoreException -> 0x0025, GeneralSecurityException -> 0x001f, IOException -> 0x0019, IllegalAccessException -> 0x0013, IllegalArgumentException -> 0x000d }
            goto L_0x0031
        L_0x000d:
            java.lang.String r2 = "Get SocketFactory Illegal Argument Exception."
            com.huawei.hms.support.log.HMSLog.w(r0, r2)
            goto L_0x0030
        L_0x0013:
            java.lang.String r2 = "Get SocketFactory Illegal Access Exception."
            com.huawei.hms.support.log.HMSLog.w(r0, r2)
            goto L_0x0030
        L_0x0019:
            java.lang.String r2 = "Get SocketFactory IO Exception."
            com.huawei.hms.support.log.HMSLog.w(r0, r2)
            goto L_0x0030
        L_0x001f:
            java.lang.String r2 = "Get SocketFactory General Security Exception."
            com.huawei.hms.support.log.HMSLog.w(r0, r2)
            goto L_0x0030
        L_0x0025:
            java.lang.String r2 = "Get SocketFactory Key Store exception."
            com.huawei.hms.support.log.HMSLog.w(r0, r2)
            goto L_0x0030
        L_0x002b:
            java.lang.String r2 = "Get SocketFactory Algorithm Exception."
            com.huawei.hms.support.log.HMSLog.w(r0, r2)
        L_0x0030:
            r2 = 0
        L_0x0031:
            if (r2 == 0) goto L_0x003c
            r3.setSSLSocketFactory(r2)
            org.apache.http.conn.ssl.X509HostnameVerifier r2 = com.huawei.secure.android.common.ssl.SecureSSLSocketFactory.STRICT_HOSTNAME_VERIFIER
            r3.setHostnameVerifier(r2)
            goto L_0x0044
        L_0x003c:
            java.lang.Exception r2 = new java.lang.Exception
            java.lang.String r3 = "No ssl socket factory set."
            r2.<init>(r3)
            throw r2
        L_0x0044:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.opendevice.g.a(android.content.Context, java.net.HttpURLConnection):void");
    }
}

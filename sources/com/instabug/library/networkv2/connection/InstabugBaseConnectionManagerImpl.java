package com.instabug.library.networkv2.connection;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.networkv2.RateLimitedException;
import com.instabug.library.networkv2.RequestException;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.authorization.NetworkOfficer;
import com.instabug.library.networkv2.f;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.networkv2.request.RequestParameter;
import com.instabug.library.util.InstabugSDKLogger;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

@Instrumented
public abstract class InstabugBaseConnectionManagerImpl implements a {
    public HttpURLConnection buildBaseConnection(Request request) throws Exception {
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(URLConnectionInstrumentation.openConnection(new URL(request.getRequestUrl()).openConnection())));
        httpURLConnection.setRequestProperty("Content-Type", getContentType());
        httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
        String requestMethod = request.getRequestMethod();
        if (requestMethod != null) {
            httpURLConnection.setRequestMethod(requestMethod);
        }
        if (f.a() && f.a(httpURLConnection.getURL().toString())) {
            String a11 = NetworkOfficer.a(request);
            if (!a11.isEmpty()) {
                httpURLConnection.setRequestProperty("Authorization", a11);
            }
        }
        for (RequestParameter next : request.getHeaders()) {
            httpURLConnection.setRequestProperty(next.getKey(), (String) next.getValue());
        }
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x009a, code lost:
        if (r8.getMessage() == null) goto L_0x00e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00de, code lost:
        if (r8.getMessage() == null) goto L_0x00e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x00e0, code lost:
        r0 = r8.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00e4, code lost:
        com.instabug.library.util.InstabugSDKLogger.e("IBG-Core", r0, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:?, code lost:
        return "";
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c A[Catch:{ all -> 0x0055 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0071 A[Catch:{ all -> 0x0055 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x007b A[Catch:{ IOException -> 0x0080 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00c0 A[Catch:{ IOException -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00f6 A[Catch:{ IOException -> 0x00fa }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String convertStreamToString(java.io.InputStream r8) {
        /*
            r7 = this;
            java.lang.String r0 = "Failed to close stream of a request"
            java.lang.String r1 = "IBG-Core"
            r2 = 0
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ OutOfMemoryError -> 0x009d, Exception -> 0x0062, all -> 0x005f }
            java.lang.String r4 = "UTF-8"
            r3.<init>(r8, r4)     // Catch:{ OutOfMemoryError -> 0x009d, Exception -> 0x0062, all -> 0x005f }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ OutOfMemoryError -> 0x005a, Exception -> 0x0058 }
            r2.<init>(r3)     // Catch:{ OutOfMemoryError -> 0x005a, Exception -> 0x0058 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ OutOfMemoryError -> 0x005a, Exception -> 0x0058 }
            r4.<init>()     // Catch:{ OutOfMemoryError -> 0x005a, Exception -> 0x0058 }
        L_0x0016:
            java.lang.String r5 = r2.readLine()     // Catch:{ OutOfMemoryError -> 0x005a, Exception -> 0x0058 }
            if (r5 == 0) goto L_0x0025
            r4.append(r5)     // Catch:{ OutOfMemoryError -> 0x005a, Exception -> 0x0058 }
            r5 = 10
            r4.append(r5)     // Catch:{ OutOfMemoryError -> 0x005a, Exception -> 0x0058 }
            goto L_0x0016
        L_0x0025:
            r3.close()     // Catch:{ OutOfMemoryError -> 0x005a, Exception -> 0x0058 }
            java.lang.String r2 = r4.toString()     // Catch:{ OutOfMemoryError -> 0x005a, Exception -> 0x0058 }
            r8.close()     // Catch:{ IOException -> 0x0033 }
            r3.close()     // Catch:{ IOException -> 0x0033 }
            goto L_0x0054
        L_0x0033:
            r8 = move-exception
            r3.close()     // Catch:{ IOException -> 0x0038 }
            goto L_0x0047
        L_0x0038:
            java.lang.String r3 = r8.getMessage()
            if (r3 == 0) goto L_0x0043
            java.lang.String r3 = r8.getMessage()
            goto L_0x0044
        L_0x0043:
            r3 = r0
        L_0x0044:
            com.instabug.library.util.InstabugSDKLogger.e(r1, r3, r8)
        L_0x0047:
            java.lang.String r3 = r8.getMessage()
            if (r3 == 0) goto L_0x0051
            java.lang.String r0 = r8.getMessage()
        L_0x0051:
            com.instabug.library.util.InstabugSDKLogger.e(r1, r0, r8)
        L_0x0054:
            return r2
        L_0x0055:
            r2 = move-exception
            goto L_0x00ee
        L_0x0058:
            r2 = move-exception
            goto L_0x0066
        L_0x005a:
            r2 = move-exception
            r6 = r3
            r3 = r2
            r2 = r6
            goto L_0x009e
        L_0x005f:
            r3 = move-exception
            goto L_0x00f1
        L_0x0062:
            r3 = move-exception
            r6 = r3
            r3 = r2
            r2 = r6
        L_0x0066:
            java.lang.String r4 = r2.getMessage()     // Catch:{ all -> 0x0055 }
            if (r4 == 0) goto L_0x0071
            java.lang.String r4 = r2.getMessage()     // Catch:{ all -> 0x0055 }
            goto L_0x0073
        L_0x0071:
            java.lang.String r4 = "Failed to convert stream of a request"
        L_0x0073:
            com.instabug.library.util.InstabugSDKLogger.e(r1, r4, r2)     // Catch:{ all -> 0x0055 }
            r8.close()     // Catch:{ IOException -> 0x0080 }
            if (r3 == 0) goto L_0x00e7
            r3.close()     // Catch:{ IOException -> 0x0080 }
            goto L_0x00e7
        L_0x0080:
            r8 = move-exception
            if (r3 == 0) goto L_0x0096
            r3.close()     // Catch:{ IOException -> 0x0087 }
            goto L_0x0096
        L_0x0087:
            java.lang.String r2 = r8.getMessage()
            if (r2 == 0) goto L_0x0092
            java.lang.String r2 = r8.getMessage()
            goto L_0x0093
        L_0x0092:
            r2 = r0
        L_0x0093:
            com.instabug.library.util.InstabugSDKLogger.e(r1, r2, r8)
        L_0x0096:
            java.lang.String r2 = r8.getMessage()
            if (r2 == 0) goto L_0x00e4
            goto L_0x00e0
        L_0x009d:
            r3 = move-exception
        L_0x009e:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ea }
            r4.<init>()     // Catch:{ all -> 0x00ea }
            java.lang.String r5 = "Failed to convert stream of a request: "
            r4.append(r5)     // Catch:{ all -> 0x00ea }
            java.lang.String r5 = r3.getMessage()     // Catch:{ all -> 0x00ea }
            r4.append(r5)     // Catch:{ all -> 0x00ea }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00ea }
            com.instabug.library.core.InstabugCore.reportError(r3, r4)     // Catch:{ all -> 0x00ea }
            java.lang.String r3 = "Failed to convert stream of a request due an OOM "
            com.instabug.library.util.InstabugSDKLogger.e(r1, r3)     // Catch:{ all -> 0x00ea }
            r8.close()     // Catch:{ IOException -> 0x00c4 }
            if (r2 == 0) goto L_0x00e7
            r2.close()     // Catch:{ IOException -> 0x00c4 }
            goto L_0x00e7
        L_0x00c4:
            r8 = move-exception
            if (r2 == 0) goto L_0x00da
            r2.close()     // Catch:{ IOException -> 0x00cb }
            goto L_0x00da
        L_0x00cb:
            java.lang.String r2 = r8.getMessage()
            if (r2 == 0) goto L_0x00d6
            java.lang.String r2 = r8.getMessage()
            goto L_0x00d7
        L_0x00d6:
            r2 = r0
        L_0x00d7:
            com.instabug.library.util.InstabugSDKLogger.e(r1, r2, r8)
        L_0x00da:
            java.lang.String r2 = r8.getMessage()
            if (r2 == 0) goto L_0x00e4
        L_0x00e0:
            java.lang.String r0 = r8.getMessage()
        L_0x00e4:
            com.instabug.library.util.InstabugSDKLogger.e(r1, r0, r8)
        L_0x00e7:
            java.lang.String r8 = ""
            return r8
        L_0x00ea:
            r3 = move-exception
            r6 = r3
            r3 = r2
            r2 = r6
        L_0x00ee:
            r6 = r3
            r3 = r2
            r2 = r6
        L_0x00f1:
            r8.close()     // Catch:{ IOException -> 0x00fa }
            if (r2 == 0) goto L_0x011d
            r2.close()     // Catch:{ IOException -> 0x00fa }
            goto L_0x011d
        L_0x00fa:
            r8 = move-exception
            if (r2 == 0) goto L_0x0110
            r2.close()     // Catch:{ IOException -> 0x0101 }
            goto L_0x0110
        L_0x0101:
            java.lang.String r2 = r8.getMessage()
            if (r2 == 0) goto L_0x010c
            java.lang.String r2 = r8.getMessage()
            goto L_0x010d
        L_0x010c:
            r2 = r0
        L_0x010d:
            com.instabug.library.util.InstabugSDKLogger.e(r1, r2, r8)
        L_0x0110:
            java.lang.String r2 = r8.getMessage()
            if (r2 == 0) goto L_0x011a
            java.lang.String r0 = r8.getMessage()
        L_0x011a:
            com.instabug.library.util.InstabugSDKLogger.e(r1, r0, r8)
        L_0x011d:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.networkv2.connection.InstabugBaseConnectionManagerImpl.convertStreamToString(java.io.InputStream):java.lang.String");
    }

    public HttpURLConnection create(Request request) throws Exception {
        InstabugSDKLogger.d("IBG-Core", "Starting a request to url: " + request.getRequestUrlForLogging());
        return setupConnection(buildBaseConnection(request), request);
    }

    public abstract /* synthetic */ int getConnectTimeOut();

    public abstract /* synthetic */ String getContentType();

    public Map<String, String> getHeaderFields(HttpURLConnection httpURLConnection) {
        HashMap hashMap = new HashMap();
        for (String next : httpURLConnection.getHeaderFields().keySet()) {
            if (next != null) {
                hashMap.put(next, httpURLConnection.getHeaderField(next));
            }
        }
        return hashMap;
    }

    public abstract /* synthetic */ int getReadTimeOut();

    public abstract /* synthetic */ RequestResponse handleResponse(HttpURLConnection httpURLConnection, Request request) throws IOException;

    public Throwable handleServerError(HttpURLConnection httpURLConnection) throws Exception {
        try {
            InputStream errorStream = httpURLConnection.getErrorStream();
            String str = "";
            if (httpURLConnection.getURL() != null && f.c(httpURLConnection.getURL().toString())) {
                InstabugSDKLogger.e("IBG-Core", "Network request got error");
                str = convertStreamToString(errorStream);
                InstabugSDKLogger.e("IBG-Core", "Error getting Network request response: " + str);
            }
            if (str.isEmpty() || httpURLConnection.getResponseCode() != 429) {
                return new RequestException(httpURLConnection.getResponseCode(), str);
            }
            return RateLimitedException.fromResponse(str);
        } catch (OutOfMemoryError e11) {
            InstabugCore.reportError(e11, "OOM while getting network request response: " + e11.getMessage());
            InstabugSDKLogger.e("IBG-Core", "OOM while getting network request response: " + e11.getMessage(), e11);
            return e11;
        }
    }

    public abstract /* synthetic */ HttpURLConnection setupConnection(HttpURLConnection httpURLConnection, Request request) throws Exception;
}

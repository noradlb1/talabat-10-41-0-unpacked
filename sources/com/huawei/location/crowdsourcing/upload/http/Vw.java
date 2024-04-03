package com.huawei.location.crowdsourcing.upload.http;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.location.lite.common.log.LogConsole;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@Instrumented
public abstract class Vw {
    private final SortedMap<String, String> FB = new TreeMap();
    private final SortedMap<String, String> LW = new TreeMap();
    private final String Vw;
    private final yn dC;

    /* renamed from: yn  reason: collision with root package name */
    private final String f50086yn;

    public enum yn {
        POST("POST"),
        PUT("PUT");
        
        private final String LW;

        private yn(String str) {
            this.LW = str;
        }

        public String a() {
            return this.LW;
        }

        public String toString() {
            return "Method{value='" + this.LW + '\'' + AbstractJsonLexerKt.END_OBJ;
        }
    }

    public Vw(@NonNull yn ynVar, @NonNull String str) {
        this.dC = ynVar;
        String str2 = "";
        if (str.contains("@") || str.contains("\\.") || str.contains("\\\\.") || str.contains("\\")) {
            this.f50086yn = str2;
            this.Vw = str2;
            LogConsole.e("HttpsRequest", "url is not correct");
            return;
        }
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (scheme == null || !scheme.toLowerCase(Locale.ENGLISH).equals("https")) {
            this.f50086yn = str2;
            this.Vw = str2;
            LogConsole.e("HttpsRequest", "not https");
            return;
        }
        String authority = parse.getAuthority();
        String host = parse.getHost();
        String path = parse.getPath();
        if (host == null) {
            LogConsole.e("HttpsRequest", "uri host is undefined");
        }
        authority = authority == null ? str2 : authority;
        str2 = path != null ? path : str2;
        this.f50086yn = authority;
        this.Vw = str2;
        yn(parse);
    }

    public Vw(@NonNull yn ynVar, @NonNull String str, @NonNull String str2) {
        this.dC = ynVar;
        this.f50086yn = str;
        this.Vw = str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        com.huawei.location.lite.common.log.LogConsole.d("HttpsRequest", "request body length:" + r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0034, code lost:
        if (r3 == null) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003a, code lost:
        r3 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0047, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0048, code lost:
        if (r3 != null) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0052, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0056, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x005b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        r3.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0060, code lost:
        com.huawei.location.lite.common.log.LogConsole.e("HttpsRequest", "IO or close failed");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0066, code lost:
        r9 = "protocol error, method:" + r9.getRequestMethod();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:18:0x003c, B:36:0x0055, B:39:0x0057] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean Vw(javax.net.ssl.HttpsURLConnection r9) {
        /*
            r8 = this;
            java.io.InputStream r0 = r8.b()
            java.lang.String r1 = "HttpsRequest"
            r2 = 0
            if (r0 != 0) goto L_0x000f
            java.lang.String r9 = "get body error"
        L_0x000b:
            com.huawei.location.lite.common.log.LogConsole.e(r1, r9)
            return r2
        L_0x000f:
            java.io.OutputStream r3 = r9.getOutputStream()     // Catch:{ all -> 0x0053 }
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch:{ all -> 0x0045 }
            r5 = r2
        L_0x0018:
            int r6 = r0.read(r4)     // Catch:{ all -> 0x0045 }
            r7 = -1
            if (r6 != r7) goto L_0x0040
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0045 }
            r4.<init>()     // Catch:{ all -> 0x0045 }
            java.lang.String r6 = "request body length:"
            r4.append(r6)     // Catch:{ all -> 0x0045 }
            r4.append(r5)     // Catch:{ all -> 0x0045 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0045 }
            com.huawei.location.lite.common.log.LogConsole.d(r1, r4)     // Catch:{ all -> 0x0045 }
            r4 = 1
            if (r3 == 0) goto L_0x003c
            r3.close()     // Catch:{ all -> 0x003a }
            goto L_0x003c
        L_0x003a:
            r3 = move-exception
            goto L_0x0055
        L_0x003c:
            r0.close()     // Catch:{ ProtocolException -> 0x0066, IOException -> 0x0060 }
            goto L_0x0065
        L_0x0040:
            r3.write(r4, r2, r6)     // Catch:{ all -> 0x0045 }
            int r5 = r5 + r6
            goto L_0x0018
        L_0x0045:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0047 }
        L_0x0047:
            r5 = move-exception
            if (r3 == 0) goto L_0x0052
            r3.close()     // Catch:{ all -> 0x004e }
            goto L_0x0052
        L_0x004e:
            r3 = move-exception
            r4.addSuppressed(r3)     // Catch:{ all -> 0x0053 }
        L_0x0052:
            throw r5     // Catch:{ all -> 0x0053 }
        L_0x0053:
            r3 = move-exception
            r4 = r2
        L_0x0055:
            throw r3     // Catch:{ all -> 0x0056 }
        L_0x0056:
            r5 = move-exception
            r0.close()     // Catch:{ all -> 0x005b }
            goto L_0x005f
        L_0x005b:
            r0 = move-exception
            r3.addSuppressed(r0)     // Catch:{ ProtocolException -> 0x0066, IOException -> 0x0060 }
        L_0x005f:
            throw r5     // Catch:{ ProtocolException -> 0x0066, IOException -> 0x0060 }
        L_0x0060:
            java.lang.String r9 = "IO or close failed"
            com.huawei.location.lite.common.log.LogConsole.e(r1, r9)
        L_0x0065:
            return r4
        L_0x0066:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "protocol error, method:"
            r0.append(r3)
            java.lang.String r9 = r9.getRequestMethod()
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            goto L_0x000b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.crowdsourcing.upload.http.Vw.Vw(javax.net.ssl.HttpsURLConnection):boolean");
    }

    public static String f(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            LogConsole.e("HttpsRequest", "not support UTF-8");
            return "";
        }
    }

    public static String g(SortedMap<String, String> sortedMap) {
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry next : sortedMap.entrySet()) {
            if (sb2.length() > 0) {
                sb2.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb2.append((String) next.getKey());
            sb2.append("=");
            sb2.append((String) next.getValue());
        }
        return sb2.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00bc, code lost:
        r4 = r3.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00d1, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00d2, code lost:
        if (r1 != null) goto L_0x00d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00dc, code lost:
        throw r3;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String yn(javax.net.ssl.HttpsURLConnection r10) {
        /*
            r9 = this;
            java.lang.String r0 = "HttpsRequest"
            r1 = 1
            r2 = 0
            com.huawei.location.crowdsourcing.upload.http.Vw$yn r3 = r9.dC     // Catch:{ ProtocolException -> 0x0043 }
            java.lang.String r3 = r3.a()     // Catch:{ ProtocolException -> 0x0043 }
            r10.setRequestMethod(r3)     // Catch:{ ProtocolException -> 0x0043 }
            java.util.SortedMap<java.lang.String, java.lang.String> r3 = r9.FB
            java.util.Set r3 = r3.entrySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x0017:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0033
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r4 = r4.getValue()
            java.lang.String r4 = (java.lang.String) r4
            r10.setRequestProperty(r5, r4)
            goto L_0x0017
        L_0x0033:
            r10.setDoOutput(r1)
            r10.setUseCaches(r2)
            r3 = 30000(0x7530, float:4.2039E-41)
            r10.setReadTimeout(r3)
            r10.setConnectTimeout(r3)
            r3 = r1
            goto L_0x005a
        L_0x0043:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "protocol not support."
            r3.append(r4)
            com.huawei.location.crowdsourcing.upload.http.Vw$yn r4 = r9.dC
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.huawei.location.lite.common.log.LogConsole.e(r0, r3)
            r3 = r2
        L_0x005a:
            r4 = 0
            if (r3 != 0) goto L_0x0063
            java.lang.String r10 = "fill connection failed"
            com.huawei.location.lite.common.log.LogConsole.e(r0, r10)
            return r4
        L_0x0063:
            boolean r3 = r9.Vw(r10)
            if (r3 != 0) goto L_0x006f
            java.lang.String r10 = "write all failed"
            com.huawei.location.lite.common.log.LogConsole.e(r0, r10)
            return r4
        L_0x006f:
            int r3 = r10.getResponseCode()     // Catch:{ IOException -> 0x00f9 }
            r5 = 200(0xc8, float:2.8E-43)
            if (r3 < r5) goto L_0x007c
            r5 = 300(0x12c, float:4.2E-43)
            if (r3 >= r5) goto L_0x007c
            goto L_0x007d
        L_0x007c:
            r1 = r2
        L_0x007d:
            if (r1 != 0) goto L_0x0094
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r1 = "http code error"
            r10.append(r1)
            r10.append(r3)
            java.lang.String r10 = r10.toString()
            com.huawei.location.lite.common.log.LogConsole.e(r0, r10)
            return r4
        L_0x0094:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r5 = "http code:"
            r1.append(r5)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            com.huawei.location.lite.common.log.LogConsole.d(r0, r1)
            java.io.InputStream r1 = r10.getInputStream()     // Catch:{ FileNotFoundException -> 0x00e0, IOException -> 0x00dd }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cf }
            r3.<init>()     // Catch:{ all -> 0x00cf }
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch:{ all -> 0x00cf }
        L_0x00b5:
            int r6 = r1.read(r5)     // Catch:{ all -> 0x00cf }
            r7 = -1
            if (r6 != r7) goto L_0x00c4
            java.lang.String r4 = r3.toString()     // Catch:{ all -> 0x00cf }
            r1.close()     // Catch:{ FileNotFoundException -> 0x00e0, IOException -> 0x00dd }
            goto L_0x00f8
        L_0x00c4:
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x00cf }
            java.nio.charset.Charset r8 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ all -> 0x00cf }
            r7.<init>(r5, r2, r6, r8)     // Catch:{ all -> 0x00cf }
            r3.append(r7)     // Catch:{ all -> 0x00cf }
            goto L_0x00b5
        L_0x00cf:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x00d1 }
        L_0x00d1:
            r3 = move-exception
            if (r1 == 0) goto L_0x00dc
            r1.close()     // Catch:{ all -> 0x00d8 }
            goto L_0x00dc
        L_0x00d8:
            r1 = move-exception
            r2.addSuppressed(r1)     // Catch:{ FileNotFoundException -> 0x00e0, IOException -> 0x00dd }
        L_0x00dc:
            throw r3     // Catch:{ FileNotFoundException -> 0x00e0, IOException -> 0x00dd }
        L_0x00dd:
            java.lang.String r10 = "read all error"
            goto L_0x00f5
        L_0x00e0:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "path not exist. url:"
            r1.append(r2)
            java.net.URL r10 = r10.getURL()
            r1.append(r10)
            java.lang.String r10 = r1.toString()
        L_0x00f5:
            com.huawei.location.lite.common.log.LogConsole.e(r0, r10)
        L_0x00f8:
            return r4
        L_0x00f9:
            java.lang.String r10 = "get response code error, io exception."
            com.huawei.location.lite.common.log.LogConsole.e(r0, r10)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.crowdsourcing.upload.http.Vw.yn(javax.net.ssl.HttpsURLConnection):java.lang.String");
    }

    private void yn(@NonNull Uri uri) {
        try {
            for (String next : uri.getQueryParameterNames()) {
                String queryParameter = uri.getQueryParameter(next);
                if (queryParameter == null) {
                    LogConsole.e("HttpsRequest", "arg value null.");
                    LogConsole.d("HttpsRequest", "arg value null. arg name:" + next);
                } else {
                    Vw(next, queryParameter);
                }
            }
        } catch (UnsupportedOperationException unused) {
            LogConsole.e("HttpsRequest", "url not support");
        }
    }

    public Vw Vw(@NonNull String str, @NonNull String str2) {
        String f11 = f(str);
        String f12 = f(str2);
        if (!f11.isEmpty() && !f12.isEmpty()) {
            this.LW.put(f11, f12);
        }
        return this;
    }

    public String a() {
        return this.Vw;
    }

    @Nullable
    public abstract InputStream b();

    public String c() {
        return this.dC.a();
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0027 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean d() {
        /*
            r4 = this;
            java.lang.String r0 = r4.f50086yn
            boolean r0 = r0.isEmpty()
            r1 = 1
            r2 = 0
            java.lang.String r3 = "HttpsRequest"
            if (r0 == 0) goto L_0x0013
            java.lang.String r0 = "domain empty"
        L_0x000e:
            com.huawei.location.lite.common.log.LogConsole.e(r3, r0)
            r0 = r2
            goto L_0x001f
        L_0x0013:
            java.lang.String r0 = r4.Vw
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x001e
            java.lang.String r0 = "path empty"
            goto L_0x000e
        L_0x001e:
            r0 = r1
        L_0x001f:
            if (r0 != 0) goto L_0x0027
            java.lang.String r0 = "valid failed"
            com.huawei.location.lite.common.log.LogConsole.e(r3, r0)
            return r2
        L_0x0027:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.crowdsourcing.upload.http.Vw.d():boolean");
    }

    public String e() {
        return g(this.LW);
    }

    public Vw yn(@NonNull String str, @NonNull String str2) {
        if (str.isEmpty()) {
            return this;
        }
        this.FB.put(str, str2);
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0079, code lost:
        if (r3 != null) goto L_0x00a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0085, code lost:
        if (r3 != null) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0087, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a3, code lost:
        if (r3 != null) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a6, code lost:
        r3.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00aa, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ab, code lost:
        if (r0 != null) goto L_0x00b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ad, code lost:
        com.huawei.location.lite.common.log.LogConsole.e("HttpsRequest", "responseContent null");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b2, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b7, code lost:
        if (r0.isEmpty() == false) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b9, code lost:
        com.huawei.location.lite.common.log.LogConsole.d("HttpsRequest", "body empty and treat as success");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        r8 = r8.newInstance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c3, code lost:
        r8 = "can not create resp, InstantiationException";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c6, code lost:
        r8 = "can not create resp, IllegalAccessException";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00c9, code lost:
        com.huawei.location.lite.common.log.LogConsole.d("HttpsRequest", "response body length:" + r0.length());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r3 = com.huawei.location.lite.common.util.GsonUtil.getInstance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00e7, code lost:
        if ((r3 instanceof com.google.gson.Gson) != false) goto L_0x00ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e9, code lost:
        r8 = r3.fromJson(r0, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00ee, code lost:
        r8 = com.newrelic.agent.android.instrumentation.GsonInstrumentation.fromJson(r3, r0, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00f3, code lost:
        r8 = "json syntax error";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00f5, code lost:
        com.huawei.location.lite.common.log.LogConsole.e("HttpsRequest", r8);
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00f9, code lost:
        r8 = (com.huawei.location.crowdsourcing.upload.http.yn) r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00fb, code lost:
        if (r8 == null) goto L_0x00fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00fd, code lost:
        com.huawei.location.lite.common.log.LogConsole.e("HttpsRequest", "response null");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0107, code lost:
        if (r8.Vw() == false) goto L_0x0109;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0109, code lost:
        com.huawei.location.lite.common.log.LogConsole.e("HttpsRequest", "response failed. reason:" + r8.a());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0122, code lost:
        com.huawei.location.lite.common.log.LogConsole.d("HttpsRequest", "got response");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        return r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x012d  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <R extends com.huawei.location.crowdsourcing.upload.http.yn> R yn(@androidx.annotation.NonNull java.lang.Class<? extends R> r8) {
        /*
            r7 = this;
            boolean r0 = r7.d()
            r1 = 0
            java.lang.String r2 = "HttpsRequest"
            if (r0 != 0) goto L_0x000f
            java.lang.String r8 = "pre execute failed"
            com.huawei.location.lite.common.log.LogConsole.e(r2, r8)
            return r1
        L_0x000f:
            java.util.SortedMap<java.lang.String, java.lang.String> r0 = r7.LW
            java.lang.String r0 = g(r0)
            java.lang.String r3 = r7.f50086yn
            java.lang.String r4 = r7.Vw
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "https"
            r5.append(r6)
            java.lang.String r6 = "://"
            r5.append(r6)
            r5.append(r3)
            r5.append(r4)
            boolean r3 = r0.isEmpty()
            if (r3 != 0) goto L_0x003c
            java.lang.String r3 = "?"
            r5.append(r3)
            r5.append(r0)
        L_0x003c:
            java.lang.String r0 = r5.toString()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x0089, IOException -> 0x007f, all -> 0x007c }
            r3.<init>()     // Catch:{ MalformedURLException -> 0x0089, IOException -> 0x007f, all -> 0x007c }
            java.lang.String r4 = "url:"
            r3.append(r4)     // Catch:{ MalformedURLException -> 0x0089, IOException -> 0x007f, all -> 0x007c }
            r3.append(r0)     // Catch:{ MalformedURLException -> 0x0089, IOException -> 0x007f, all -> 0x007c }
            java.lang.String r3 = r3.toString()     // Catch:{ MalformedURLException -> 0x0089, IOException -> 0x007f, all -> 0x007c }
            com.huawei.location.lite.common.log.LogConsole.d(r2, r3)     // Catch:{ MalformedURLException -> 0x0089, IOException -> 0x007f, all -> 0x007c }
            java.net.URL r3 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0089, IOException -> 0x007f, all -> 0x007c }
            r3.<init>(r0)     // Catch:{ MalformedURLException -> 0x0089, IOException -> 0x007f, all -> 0x007c }
            java.net.URLConnection r3 = r3.openConnection()     // Catch:{ MalformedURLException -> 0x0089, IOException -> 0x007f, all -> 0x007c }
            java.net.URLConnection r3 = com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation.openConnection(r3)     // Catch:{ MalformedURLException -> 0x0089, IOException -> 0x007f, all -> 0x007c }
            java.lang.Object r3 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r3)     // Catch:{ MalformedURLException -> 0x0089, IOException -> 0x007f, all -> 0x007c }
            java.net.URLConnection r3 = (java.net.URLConnection) r3     // Catch:{ MalformedURLException -> 0x0089, IOException -> 0x007f, all -> 0x007c }
            boolean r4 = r3 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ MalformedURLException -> 0x0089, IOException -> 0x007f, all -> 0x007c }
            if (r4 == 0) goto L_0x0072
            javax.net.ssl.HttpsURLConnection r3 = (javax.net.ssl.HttpsURLConnection) r3     // Catch:{ MalformedURLException -> 0x0089, IOException -> 0x007f, all -> 0x007c }
            java.lang.String r0 = r7.yn((javax.net.ssl.HttpsURLConnection) r3)     // Catch:{ MalformedURLException -> 0x008a, IOException -> 0x0080 }
            goto L_0x0079
        L_0x0072:
            java.lang.String r3 = "not HttpsURLConnection"
            com.huawei.location.lite.common.log.LogConsole.e(r2, r3)     // Catch:{ MalformedURLException -> 0x0089, IOException -> 0x007f, all -> 0x007c }
            r0 = r1
            r3 = r0
        L_0x0079:
            if (r3 == 0) goto L_0x00ab
            goto L_0x00a6
        L_0x007c:
            r8 = move-exception
            goto L_0x012b
        L_0x007f:
            r3 = r1
        L_0x0080:
            java.lang.String r0 = "connection error."
            com.huawei.location.lite.common.log.LogConsole.e(r2, r0)     // Catch:{ all -> 0x0129 }
            if (r3 == 0) goto L_0x00aa
        L_0x0087:
            r0 = r1
            goto L_0x00a6
        L_0x0089:
            r3 = r1
        L_0x008a:
            java.lang.String r4 = "url format error."
            com.huawei.location.lite.common.log.LogConsole.e(r2, r4)     // Catch:{ all -> 0x0129 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0129 }
            r4.<init>()     // Catch:{ all -> 0x0129 }
            java.lang.String r5 = "url format error, url:"
            r4.append(r5)     // Catch:{ all -> 0x0129 }
            r4.append(r0)     // Catch:{ all -> 0x0129 }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x0129 }
            com.huawei.location.lite.common.log.LogConsole.d(r2, r0)     // Catch:{ all -> 0x0129 }
            if (r3 == 0) goto L_0x00aa
            goto L_0x0087
        L_0x00a6:
            r3.disconnect()
            goto L_0x00ab
        L_0x00aa:
            r0 = r1
        L_0x00ab:
            if (r0 != 0) goto L_0x00b3
            java.lang.String r8 = "responseContent null"
            com.huawei.location.lite.common.log.LogConsole.e(r2, r8)
            return r1
        L_0x00b3:
            boolean r3 = r0.isEmpty()
            if (r3 == 0) goto L_0x00c9
            java.lang.String r0 = "body empty and treat as success"
            com.huawei.location.lite.common.log.LogConsole.d(r2, r0)
            java.lang.Object r8 = r8.newInstance()     // Catch:{ IllegalAccessException -> 0x00c6, InstantiationException -> 0x00c3 }
            goto L_0x00f9
        L_0x00c3:
            java.lang.String r8 = "can not create resp, InstantiationException"
            goto L_0x00f5
        L_0x00c6:
            java.lang.String r8 = "can not create resp, IllegalAccessException"
            goto L_0x00f5
        L_0x00c9:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "response body length:"
            r3.append(r4)
            int r4 = r0.length()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            com.huawei.location.lite.common.log.LogConsole.d(r2, r3)
            com.google.gson.Gson r3 = com.huawei.location.lite.common.util.GsonUtil.getInstance()     // Catch:{ JsonSyntaxException -> 0x00f3 }
            boolean r4 = r3 instanceof com.google.gson.Gson     // Catch:{ JsonSyntaxException -> 0x00f3 }
            if (r4 != 0) goto L_0x00ee
            java.lang.Object r8 = r3.fromJson((java.lang.String) r0, r8)     // Catch:{ JsonSyntaxException -> 0x00f3 }
            goto L_0x00f9
        L_0x00ee:
            java.lang.Object r8 = com.newrelic.agent.android.instrumentation.GsonInstrumentation.fromJson((com.google.gson.Gson) r3, (java.lang.String) r0, r8)     // Catch:{ JsonSyntaxException -> 0x00f3 }
            goto L_0x00f9
        L_0x00f3:
            java.lang.String r8 = "json syntax error"
        L_0x00f5:
            com.huawei.location.lite.common.log.LogConsole.e(r2, r8)
            r8 = r1
        L_0x00f9:
            com.huawei.location.crowdsourcing.upload.http.yn r8 = (com.huawei.location.crowdsourcing.upload.http.yn) r8
            if (r8 != 0) goto L_0x0103
            java.lang.String r0 = "response null"
            com.huawei.location.lite.common.log.LogConsole.e(r2, r0)
            goto L_0x0127
        L_0x0103:
            boolean r0 = r8.Vw()
            if (r0 != 0) goto L_0x0122
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "response failed. reason:"
            r0.append(r3)
            java.lang.String r8 = r8.a()
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            com.huawei.location.lite.common.log.LogConsole.e(r2, r8)
            goto L_0x0128
        L_0x0122:
            java.lang.String r0 = "got response"
            com.huawei.location.lite.common.log.LogConsole.d(r2, r0)
        L_0x0127:
            r1 = r8
        L_0x0128:
            return r1
        L_0x0129:
            r8 = move-exception
            r1 = r3
        L_0x012b:
            if (r1 == 0) goto L_0x0130
            r1.disconnect()
        L_0x0130:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.crowdsourcing.upload.http.Vw.yn(java.lang.Class):com.huawei.location.crowdsourcing.upload.http.yn");
    }
}

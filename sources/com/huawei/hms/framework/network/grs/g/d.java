package com.huawei.hms.framework.network.grs.g;

import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;

@Instrumented
public class d {

    /* renamed from: o  reason: collision with root package name */
    private static final String f48896o = "d";

    /* renamed from: a  reason: collision with root package name */
    private Map<String, List<String>> f48897a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f48898b;

    /* renamed from: c  reason: collision with root package name */
    private int f48899c;

    /* renamed from: d  reason: collision with root package name */
    private long f48900d;

    /* renamed from: e  reason: collision with root package name */
    private long f48901e;

    /* renamed from: f  reason: collision with root package name */
    private long f48902f;

    /* renamed from: g  reason: collision with root package name */
    private String f48903g;

    /* renamed from: h  reason: collision with root package name */
    private int f48904h;

    /* renamed from: i  reason: collision with root package name */
    private int f48905i;

    /* renamed from: j  reason: collision with root package name */
    private String f48906j;

    /* renamed from: k  reason: collision with root package name */
    private long f48907k;

    /* renamed from: l  reason: collision with root package name */
    private String f48908l;

    /* renamed from: m  reason: collision with root package name */
    private Exception f48909m;

    /* renamed from: n  reason: collision with root package name */
    private String f48910n;

    public d(int i11, Map<String, List<String>> map, byte[] bArr, long j11) {
        this.f48904h = 2;
        this.f48905i = 9001;
        this.f48906j = "";
        this.f48907k = 0;
        this.f48908l = "";
        this.f48899c = i11;
        this.f48897a = map;
        this.f48898b = ByteBuffer.wrap(bArr).array();
        this.f48900d = j11;
        s();
    }

    public d(Exception exc, long j11) {
        this.f48899c = 0;
        this.f48904h = 2;
        this.f48905i = 9001;
        this.f48906j = "";
        this.f48907k = 0;
        this.f48908l = "";
        this.f48909m = exc;
        this.f48900d = j11;
    }

    private void a(Map<String, String> map) {
        String str;
        String str2;
        if (map.containsKey(HttpHeaders.ETAG)) {
            String str3 = map.get(HttpHeaders.ETAG);
            if (!TextUtils.isEmpty(str3)) {
                Logger.i(f48896o, "success get Etag from server");
                a(str3);
                return;
            }
            str = f48896o;
            str2 = "The Response Heads Etag is Empty";
        } else {
            str = f48896o;
            str2 = "Response Heads has not Etag";
        }
        Logger.i(str, str2);
    }

    private void b(int i11) {
        this.f48905i = i11;
    }

    private void b(Map<String, String> map) {
        long j11;
        if (map.containsKey("Cache-Control")) {
            String str = map.get("Cache-Control");
            if (!TextUtils.isEmpty(str) && str.contains("max-age=")) {
                try {
                    j11 = Long.parseLong(str.substring(str.indexOf("max-age=") + 8));
                    try {
                        Logger.v(f48896o, "Cache-Control value{%s}", Long.valueOf(j11));
                    } catch (NumberFormatException e11) {
                        e = e11;
                    }
                } catch (NumberFormatException e12) {
                    e = e12;
                    j11 = 0;
                    Logger.w(f48896o, "getExpireTime addHeadersToResult NumberFormatException", (Throwable) e);
                    j11 = 86400;
                    long j12 = j11 * 1000;
                    Logger.i(f48896o, "convert expireTime{%s}", Long.valueOf(j12));
                    c(String.valueOf(j12 + System.currentTimeMillis()));
                }
                if (j11 <= 0 || j11 > 2592000) {
                    j11 = 86400;
                }
                long j122 = j11 * 1000;
                Logger.i(f48896o, "convert expireTime{%s}", Long.valueOf(j122));
                c(String.valueOf(j122 + System.currentTimeMillis()));
            }
        } else if (map.containsKey(HttpHeaders.EXPIRES)) {
            String str2 = map.get(HttpHeaders.EXPIRES);
            Logger.v(f48896o, "expires is{%s}", str2);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.ROOT);
            String str3 = map.containsKey(HttpHeaders.DATE) ? map.get(HttpHeaders.DATE) : null;
            try {
                j11 = (simpleDateFormat.parse(str2).getTime() - (TextUtils.isEmpty(str3) ? new Date() : simpleDateFormat.parse(str3)).getTime()) / 1000;
            } catch (ParseException e13) {
                Logger.w(f48896o, "getExpireTime ParseException.", (Throwable) e13);
            }
            j11 = 86400;
            long j1222 = j11 * 1000;
            Logger.i(f48896o, "convert expireTime{%s}", Long.valueOf(j1222));
            c(String.valueOf(j1222 + System.currentTimeMillis()));
        } else {
            Logger.i(f48896o, "response headers neither contains Cache-Control nor Expires.");
        }
        j11 = 0;
        j11 = 86400;
        long j12222 = j11 * 1000;
        Logger.i(f48896o, "convert expireTime{%s}", Long.valueOf(j12222));
        c(String.valueOf(j12222 + System.currentTimeMillis()));
    }

    private void c(int i11) {
        this.f48904h = i11;
    }

    private void c(long j11) {
        this.f48907k = j11;
    }

    private void c(String str) {
        this.f48906j = str;
    }

    private void c(Map<String, String> map) {
        long j11;
        if (map.containsKey(HttpHeaders.RETRY_AFTER)) {
            String str = map.get(HttpHeaders.RETRY_AFTER);
            if (!TextUtils.isEmpty(str)) {
                try {
                    j11 = Long.parseLong(str);
                } catch (NumberFormatException e11) {
                    Logger.w(f48896o, "getRetryAfter addHeadersToResult NumberFormatException", (Throwable) e11);
                }
                long j12 = j11 * 1000;
                Logger.v(f48896o, "convert retry-afterTime{%s}", Long.valueOf(j12));
                c(j12);
            }
        }
        j11 = 0;
        long j122 = j11 * 1000;
        Logger.v(f48896o, "convert retry-afterTime{%s}", Long.valueOf(j122));
        c(j122);
    }

    private void d(String str) {
    }

    private void e(String str) {
    }

    private void f(String str) {
        this.f48903g = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0051, code lost:
        if (r9.getInt(com.adyen.checkout.core.model.WeChatPayDetails.KEY_RESULT_CODE) == 0) goto L_0x0053;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0063 A[SYNTHETIC, Splitter:B:25:0x0063] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0071 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0098 A[Catch:{ JSONException -> 0x00ca }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00aa A[Catch:{ JSONException -> 0x00ca }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00b4 A[Catch:{ JSONException -> 0x00ca }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void p() {
        /*
            r10 = this;
            java.lang.String r0 = "errorDesc"
            java.lang.String r1 = "errorList"
            java.lang.String r2 = "errorCode"
            java.lang.String r3 = "resultCode"
            java.lang.String r4 = "isSuccess"
            boolean r5 = r10.m()
            r6 = 1
            if (r5 == 0) goto L_0x001c
            java.lang.String r0 = f48896o
            java.lang.String r1 = "GRSSDK get httpcode{304} not any changed."
            com.huawei.hms.framework.common.Logger.i(r0, r1)
            r10.c((int) r6)
            return
        L_0x001c:
            boolean r5 = r10.o()
            r7 = 2
            if (r5 != 0) goto L_0x002e
            java.lang.String r0 = f48896o
            java.lang.String r1 = "GRSSDK parse server body all failed."
            com.huawei.hms.framework.common.Logger.i(r0, r1)
            r10.c((int) r7)
            return
        L_0x002e:
            r5 = 0
            byte[] r8 = r10.f48898b     // Catch:{ JSONException -> 0x00ca }
            java.lang.String r8 = com.huawei.hms.framework.common.StringUtils.byte2Str(r8)     // Catch:{ JSONException -> 0x00ca }
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00ca }
            r9.<init>((java.lang.String) r8)     // Catch:{ JSONException -> 0x00ca }
            boolean r8 = r9.has(r4)     // Catch:{ JSONException -> 0x00ca }
            if (r8 == 0) goto L_0x0047
            int r3 = r9.getInt(r4)     // Catch:{ JSONException -> 0x00ca }
            if (r3 != r6) goto L_0x0055
            goto L_0x0053
        L_0x0047:
            boolean r4 = r9.has(r3)     // Catch:{ JSONException -> 0x00ca }
            if (r4 == 0) goto L_0x0057
            int r3 = r9.getInt(r3)     // Catch:{ JSONException -> 0x00ca }
            if (r3 != 0) goto L_0x0055
        L_0x0053:
            r3 = r6
            goto L_0x005f
        L_0x0055:
            r3 = r7
            goto L_0x005f
        L_0x0057:
            java.lang.String r3 = f48896o     // Catch:{ JSONException -> 0x00ca }
            java.lang.String r4 = "sth. wrong because server errorcode's key."
            com.huawei.hms.framework.common.Logger.e(r3, r4)     // Catch:{ JSONException -> 0x00ca }
            r3 = -1
        L_0x005f:
            java.lang.String r4 = "services"
            if (r3 == r6) goto L_0x006a
            boolean r8 = r9.has(r4)     // Catch:{ JSONException -> 0x00ca }
            if (r8 == 0) goto L_0x006a
            r3 = r5
        L_0x006a:
            r10.c((int) r3)     // Catch:{ JSONException -> 0x00ca }
            java.lang.String r8 = ""
            if (r3 == r6) goto L_0x0092
            if (r3 != 0) goto L_0x0074
            goto L_0x0092
        L_0x0074:
            boolean r1 = r9.has(r2)     // Catch:{ JSONException -> 0x00ca }
            if (r1 == 0) goto L_0x007f
            int r1 = r9.getInt(r2)     // Catch:{ JSONException -> 0x00ca }
            goto L_0x0081
        L_0x007f:
            r1 = 9001(0x2329, float:1.2613E-41)
        L_0x0081:
            r10.b((int) r1)     // Catch:{ JSONException -> 0x00ca }
            boolean r1 = r9.has(r0)     // Catch:{ JSONException -> 0x00ca }
            if (r1 == 0) goto L_0x008e
            java.lang.String r8 = r9.getString(r0)     // Catch:{ JSONException -> 0x00ca }
        L_0x008e:
            r10.d(r8)     // Catch:{ JSONException -> 0x00ca }
            goto L_0x00e1
        L_0x0092:
            boolean r0 = r9.has(r4)     // Catch:{ JSONException -> 0x00ca }
            if (r0 == 0) goto L_0x00aa
            org.json.JSONObject r0 = r9.getJSONObject(r4)     // Catch:{ JSONException -> 0x00ca }
            boolean r2 = r0 instanceof org.json.JSONObject     // Catch:{ JSONException -> 0x00ca }
            if (r2 != 0) goto L_0x00a5
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x00ca }
            goto L_0x00ab
        L_0x00a5:
            java.lang.String r0 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r0)     // Catch:{ JSONException -> 0x00ca }
            goto L_0x00ab
        L_0x00aa:
            r0 = r8
        L_0x00ab:
            r10.f(r0)     // Catch:{ JSONException -> 0x00ca }
            boolean r0 = r9.has(r1)     // Catch:{ JSONException -> 0x00ca }
            if (r0 == 0) goto L_0x00c6
            org.json.JSONObject r0 = r9.getJSONObject(r1)     // Catch:{ JSONException -> 0x00ca }
            boolean r1 = r0 instanceof org.json.JSONObject     // Catch:{ JSONException -> 0x00ca }
            if (r1 != 0) goto L_0x00c1
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x00ca }
            goto L_0x00c5
        L_0x00c1:
            java.lang.String r0 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r0)     // Catch:{ JSONException -> 0x00ca }
        L_0x00c5:
            r8 = r0
        L_0x00c6:
            r10.e(r8)     // Catch:{ JSONException -> 0x00ca }
            goto L_0x00e1
        L_0x00ca:
            r0 = move-exception
            java.lang.String r1 = f48896o
            java.lang.Object[] r2 = new java.lang.Object[r6]
            java.lang.String r0 = r0.getMessage()
            java.lang.String r0 = com.huawei.hms.framework.common.StringUtils.anonymizeMessage(r0)
            r2[r5] = r0
            java.lang.String r0 = "GrsResponse GrsResponse(String result) JSONException: %s"
            com.huawei.hms.framework.common.Logger.w((java.lang.String) r1, (java.lang.String) r0, (java.lang.Object[]) r2)
            r10.c((int) r7)
        L_0x00e1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.g.d.p():void");
    }

    private void q() {
        if (o() || n() || m()) {
            Map<String, String> r11 = r();
            if (r11.size() <= 0) {
                Logger.w(f48896o, "parseHeader {headers.size() <= 0}");
                return;
            }
            try {
                if (o() || m()) {
                    b(r11);
                    a(r11);
                }
                if (n()) {
                    c(r11);
                }
            } catch (JSONException e11) {
                Logger.w(f48896o, "parseHeader catch JSONException: %s", StringUtils.anonymizeMessage(e11.getMessage()));
            }
        }
    }

    private Map<String, String> r() {
        HashMap hashMap = new HashMap(16);
        Map<String, List<String>> map = this.f48897a;
        if (map == null || map.size() <= 0) {
            Logger.v(f48896o, "parseRespHeaders {respHeaders == null} or {respHeaders.size() <= 0}");
            return hashMap;
        }
        for (Map.Entry next : this.f48897a.entrySet()) {
            String str = (String) next.getKey();
            for (String put : (List) next.getValue()) {
                hashMap.put(str, put);
            }
        }
        return hashMap;
    }

    private void s() {
        q();
        p();
    }

    public String a() {
        return this.f48906j;
    }

    public void a(int i11) {
    }

    public void a(long j11) {
        this.f48902f = j11;
    }

    public void a(String str) {
        this.f48908l = str;
    }

    public int b() {
        return this.f48899c;
    }

    public void b(long j11) {
        this.f48901e = j11;
    }

    public void b(String str) {
        this.f48910n = str;
    }

    public int c() {
        return this.f48905i;
    }

    public Exception d() {
        return this.f48909m;
    }

    public String e() {
        return this.f48908l;
    }

    public int f() {
        return this.f48904h;
    }

    public long g() {
        return this.f48902f;
    }

    public long h() {
        return this.f48901e;
    }

    public long i() {
        return this.f48900d;
    }

    public String j() {
        return this.f48903g;
    }

    public long k() {
        return this.f48907k;
    }

    public String l() {
        return this.f48910n;
    }

    public boolean m() {
        return this.f48899c == 304;
    }

    public boolean n() {
        return this.f48899c == 503;
    }

    public boolean o() {
        return this.f48899c == 200;
    }
}

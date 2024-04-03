package com.uxcam.internals;

import com.newrelic.agent.android.instrumentation.Instrumented;
import com.uxcam.internals.ef;
import okhttp3.Interceptor;

@Instrumented
public final class ho implements Interceptor {

    /* renamed from: c  reason: collision with root package name */
    public static boolean f13585c = false;

    /* renamed from: a  reason: collision with root package name */
    public ef.aa.C0001aa f13586a;

    /* renamed from: b  reason: collision with root package name */
    public as f13587b;

    public static final class aa {

        /* renamed from: a  reason: collision with root package name */
        public final ef.aa.C0001aa f13588a = new ef.aa.C0001aa();
    }

    public ho(ef.aa.C0001aa aaVar) {
        this.f13586a = aaVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x014e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x014f  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Response intercept(@org.jetbrains.annotations.NotNull okhttp3.Interceptor.Chain r15) {
        /*
            r14 = this;
            long r0 = java.lang.System.currentTimeMillis()
            okhttp3.Request r2 = r15.request()
            r3 = 0
            okhttp3.Response r15 = r15.proceed(r2)     // Catch:{ all -> 0x001e }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x001c }
            com.uxcam.internals.eg$aa r6 = new com.uxcam.internals.eg$aa     // Catch:{ all -> 0x001c }
            r6.<init>(r0, r4)     // Catch:{ all -> 0x001c }
            com.uxcam.internals.eg r4 = new com.uxcam.internals.eg     // Catch:{ all -> 0x001c }
            r4.<init>(r15, r6)     // Catch:{ all -> 0x001c }
            goto L_0x0030
        L_0x001c:
            r3 = move-exception
            goto L_0x0022
        L_0x001e:
            r15 = move-exception
            r13 = r3
            r3 = r15
            r15 = r13
        L_0x0022:
            long r4 = java.lang.System.currentTimeMillis()
            com.uxcam.internals.eg$aa r6 = new com.uxcam.internals.eg$aa
            r6.<init>(r0, r4)
            com.uxcam.internals.eg r4 = new com.uxcam.internals.eg
            r4.<init>(r2, r3, r6)
        L_0x0030:
            com.uxcam.internals.ef r0 = new com.uxcam.internals.ef
            com.uxcam.internals.ef$aa$aa r1 = r14.f13586a
            com.uxcam.internals.ef$aa r2 = new com.uxcam.internals.ef$aa
            java.util.List r5 = r1.f13272a
            java.util.List r1 = r1.f13273b
            r2.<init>(r5, r1)
            r0.<init>(r4, r2)
            boolean r1 = r4.a()
            java.lang.String r2 = "receivedResponseAt"
            java.lang.String r5 = "sentRequestAt"
            java.lang.String r6 = "callDurationMs"
            java.lang.String r7 = ""
            if (r1 == 0) goto L_0x0099
            java.lang.Throwable r1 = r4.f13277d
            okhttp3.Request r8 = r4.f13275b
            org.json.JSONObject r0 = r0.a((okhttp3.Request) r8)
            com.uxcam.internals.eg$aa r8 = r4.f13278e     // Catch:{ JSONException -> 0x0085 }
            long r9 = r8.f13280b     // Catch:{ JSONException -> 0x0085 }
            long r11 = r8.f13279a     // Catch:{ JSONException -> 0x0085 }
            long r9 = r9 - r11
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0085 }
            r8.<init>()     // Catch:{ JSONException -> 0x0085 }
            r8.append(r7)     // Catch:{ JSONException -> 0x0085 }
            r8.append(r9)     // Catch:{ JSONException -> 0x0085 }
            java.lang.String r7 = r8.toString()     // Catch:{ JSONException -> 0x0085 }
            r0.put((java.lang.String) r6, (java.lang.Object) r7)     // Catch:{ JSONException -> 0x0085 }
            com.uxcam.internals.eg$aa r4 = r4.f13278e     // Catch:{ JSONException -> 0x0085 }
            long r6 = r4.f13279a     // Catch:{ JSONException -> 0x0085 }
            r0.put((java.lang.String) r5, (long) r6)     // Catch:{ JSONException -> 0x0085 }
            long r4 = r4.f13280b     // Catch:{ JSONException -> 0x0085 }
            r0.put((java.lang.String) r2, (long) r4)     // Catch:{ JSONException -> 0x0085 }
            java.lang.String r2 = "throwableMessage"
            java.lang.String r1 = r1.getMessage()     // Catch:{ JSONException -> 0x0085 }
            r0.put((java.lang.String) r2, (java.lang.Object) r1)     // Catch:{ JSONException -> 0x0085 }
            goto L_0x0089
        L_0x0085:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0089:
            boolean r1 = r0 instanceof org.json.JSONObject
            if (r1 != 0) goto L_0x0093
            java.lang.String r0 = r0.toString()
            goto L_0x0137
        L_0x0093:
            java.lang.String r0 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r0)
            goto L_0x0137
        L_0x0099:
            okhttp3.Response r1 = r4.f13276c
            okhttp3.Request r8 = r1.request()
            org.json.JSONObject r8 = r0.a((okhttp3.Request) r8)
            okhttp3.Protocol r9 = r1.protocol()     // Catch:{ JSONException -> 0x0126, IOException -> 0x0121 }
            java.lang.String r9 = r9.toString()     // Catch:{ JSONException -> 0x0126, IOException -> 0x0121 }
            java.lang.String r10 = "protocol"
            r8.put((java.lang.String) r10, (java.lang.Object) r9)     // Catch:{ JSONException -> 0x0126, IOException -> 0x0121 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0126, IOException -> 0x0121 }
            r9.<init>()     // Catch:{ JSONException -> 0x0126, IOException -> 0x0121 }
            r9.append(r7)     // Catch:{ JSONException -> 0x0126, IOException -> 0x0121 }
            int r10 = r1.code()     // Catch:{ JSONException -> 0x0126, IOException -> 0x0121 }
            r9.append(r10)     // Catch:{ JSONException -> 0x0126, IOException -> 0x0121 }
            java.lang.String r9 = r9.toString()     // Catch:{ JSONException -> 0x0126, IOException -> 0x0121 }
            java.lang.String r10 = "httpStatusCode"
            r8.put((java.lang.String) r10, (java.lang.Object) r9)     // Catch:{ JSONException -> 0x0126, IOException -> 0x0121 }
            long r9 = r1.receivedResponseAtMillis()     // Catch:{ JSONException -> 0x0126, IOException -> 0x0121 }
            long r11 = r1.sentRequestAtMillis()     // Catch:{ JSONException -> 0x0126, IOException -> 0x0121 }
            long r9 = r9 - r11
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0126, IOException -> 0x0121 }
            r11.<init>()     // Catch:{ JSONException -> 0x0126, IOException -> 0x0121 }
            r11.append(r7)     // Catch:{ JSONException -> 0x0126, IOException -> 0x0121 }
            r11.append(r9)     // Catch:{ JSONException -> 0x0126, IOException -> 0x0121 }
            java.lang.String r7 = r11.toString()     // Catch:{ JSONException -> 0x0126, IOException -> 0x0121 }
            r8.put((java.lang.String) r6, (java.lang.Object) r7)     // Catch:{ JSONException -> 0x0126, IOException -> 0x0121 }
            com.uxcam.internals.eg$aa r4 = r4.f13278e     // Catch:{ JSONException -> 0x0126, IOException -> 0x0121 }
            long r6 = r4.f13279a     // Catch:{ JSONException -> 0x0126, IOException -> 0x0121 }
            r8.put((java.lang.String) r5, (long) r6)     // Catch:{ JSONException -> 0x0126, IOException -> 0x0121 }
            long r4 = r4.f13280b     // Catch:{ JSONException -> 0x0126, IOException -> 0x0121 }
            r8.put((java.lang.String) r2, (long) r4)     // Catch:{ JSONException -> 0x0126, IOException -> 0x0121 }
            okhttp3.ResponseBody r2 = r1.body()     // Catch:{ JSONException -> 0x0126, IOException -> 0x0121 }
            if (r2 == 0) goto L_0x0113
            okio.BufferedSource r2 = r2.source()     // Catch:{ JSONException -> 0x0126, IOException -> 0x0121 }
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r2.request(r4)     // Catch:{ JSONException -> 0x0126, IOException -> 0x0121 }
            okio.Buffer r2 = r2.getBuffer()     // Catch:{ JSONException -> 0x0126, IOException -> 0x0121 }
            okio.ByteString r2 = r2.snapshot()     // Catch:{ JSONException -> 0x0126, IOException -> 0x0121 }
            int r2 = r2.size()     // Catch:{ JSONException -> 0x0126, IOException -> 0x0121 }
            long r4 = (long) r2     // Catch:{ JSONException -> 0x0126, IOException -> 0x0121 }
            java.lang.String r2 = "responseSizeBytes"
            r8.put((java.lang.String) r2, (long) r4)     // Catch:{ JSONException -> 0x0126, IOException -> 0x0121 }
        L_0x0113:
            okhttp3.Headers r1 = r1.headers()     // Catch:{ JSONException -> 0x0126, IOException -> 0x0121 }
            org.json.JSONArray r0 = r0.a((okhttp3.Headers) r1)     // Catch:{ JSONException -> 0x0126, IOException -> 0x0121 }
            java.lang.String r1 = "responseHeaders"
            r8.put((java.lang.String) r1, (java.lang.Object) r0)     // Catch:{ JSONException -> 0x0126, IOException -> 0x0121 }
            goto L_0x012a
        L_0x0121:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x012a
        L_0x0126:
            r0 = move-exception
            r0.printStackTrace()
        L_0x012a:
            boolean r0 = r8 instanceof org.json.JSONObject
            if (r0 != 0) goto L_0x0133
            java.lang.String r0 = r8.toString()
            goto L_0x0137
        L_0x0133:
            java.lang.String r0 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r8)
        L_0x0137:
            com.uxcam.internals.as r1 = r14.f13587b
            if (r1 != 0) goto L_0x0142
            com.uxcam.internals.as r1 = new com.uxcam.internals.as
            r1.<init>()
            r14.f13587b = r1
        L_0x0142:
            com.uxcam.internals.as r1 = r14.f13587b     // Catch:{ JSONException -> 0x0148 }
            r1.a(r0)     // Catch:{ JSONException -> 0x0148 }
            goto L_0x014c
        L_0x0148:
            r0 = move-exception
            r0.printStackTrace()
        L_0x014c:
            if (r15 == 0) goto L_0x014f
            return r15
        L_0x014f:
            java.io.IOException r15 = new java.io.IOException
            r15.<init>(r3)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.ho.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}

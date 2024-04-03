package com.uxcam.internals;

import androidx.annotation.NonNull;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.uxcam.internals.gu;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;

@Instrumented
public class ii implements Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f13635a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ij f13636b;

    public ii(ij ijVar, String str) {
        this.f13636b = ijVar;
        this.f13635a = str;
    }

    public void onFailure(@NonNull Call call, IOException iOException) {
        gu.ab a11 = gu.a("OkHttp");
        iOException.getMessage();
        a11.getClass();
        fz a12 = new fz().a("httpVerifyApplication").a();
        a12.a("site_of_error", "VerificationHandler::onFailure()");
        a12.a("invokes_next", "treatAsOfflineSession()");
        a12.a("reason", iOException.getMessage()).a(2);
        this.f13636b.a(this.f13635a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0086  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResponse(@androidx.annotation.NonNull okhttp3.Call r10, @androidx.annotation.NonNull okhttp3.Response r11) {
        /*
            r9 = this;
            java.lang.String r10 = "data"
            java.lang.String r0 = "reason"
            java.lang.String r1 = "httpVerifyApplication"
            java.lang.String r2 = "site_of_error"
            r3 = 2
            okhttp3.ResponseBody r4 = r11.body()     // Catch:{ JSONException -> 0x001d }
            if (r4 == 0) goto L_0x003f
            okhttp3.ResponseBody r4 = r11.body()     // Catch:{ JSONException -> 0x001d }
            java.lang.String r4 = r4.string()     // Catch:{ JSONException -> 0x001d }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x001d }
            r5.<init>((java.lang.String) r4)     // Catch:{ JSONException -> 0x001d }
            goto L_0x0040
        L_0x001d:
            r4 = move-exception
            r4.printStackTrace()
            com.uxcam.internals.fz r5 = new com.uxcam.internals.fz
            r5.<init>()
            com.uxcam.internals.fz r5 = r5.a((java.lang.String) r1)
            com.uxcam.internals.fz r5 = r5.a()
            java.lang.String r6 = "try { }"
            com.uxcam.internals.fz r5 = r5.a(r2, r6)
            java.lang.String r4 = r4.getMessage()
            com.uxcam.internals.fz r4 = r5.a(r0, r4)
            r4.a((int) r3)
        L_0x003f:
            r5 = 0
        L_0x0040:
            r4 = 0
            boolean r6 = com.uxcam.internals.ik.a(r5, r4)
            java.lang.String r7 = "VerificationHandler::onResponse() "
            if (r6 == 0) goto L_0x0086
            com.uxcam.internals.hm r10 = com.uxcam.internals.hm.f()
            r10.f13581f = r4
            com.uxcam.internals.bi.f13067b = r4
            com.uxcam.internals.fz r10 = new com.uxcam.internals.fz
            r10.<init>()
            com.uxcam.internals.fz r10 = r10.a((java.lang.String) r1)
            com.uxcam.internals.fz r10 = r10.a()
            r10.a(r2, r7)
            java.lang.String r11 = "shouldCancelSessionWithoutSendingCancellation"
            com.uxcam.internals.fz r10 = r10.a(r2, r11)
            boolean r11 = r5 instanceof org.json.JSONObject
            if (r11 != 0) goto L_0x0070
            java.lang.String r11 = r5.toString()
            goto L_0x0074
        L_0x0070:
            java.lang.String r11 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r5)
        L_0x0074:
            com.uxcam.internals.fz r10 = r10.a(r0, r11)
            r10.a((int) r3)
            com.uxcam.internals.gc r10 = new com.uxcam.internals.gc
            android.content.Context r11 = com.uxcam.internals.ia.f13617c
            r10.<init>(r11)
            r10.b()
            return
        L_0x0086:
            if (r5 == 0) goto L_0x0100
            int r6 = r11.code()
            r8 = 200(0xc8, float:2.8E-43)
            if (r6 == r8) goto L_0x0091
            goto L_0x0100
        L_0x0091:
            com.uxcam.internals.ij r11 = r9.f13636b
            java.lang.String r6 = r9.f13635a
            r11.a((org.json.JSONObject) r5, (boolean) r4, (java.lang.String) r6)
            org.json.JSONObject r11 = r5.getJSONObject(r10)     // Catch:{ JSONException -> 0x00bd }
            java.lang.String r4 = "s3"
            r11.remove(r4)     // Catch:{ JSONException -> 0x00bd }
            org.json.JSONObject r11 = r5.getJSONObject(r10)     // Catch:{ JSONException -> 0x00bd }
            java.lang.String r4 = "sessionId"
            r11.remove(r4)     // Catch:{ JSONException -> 0x00bd }
            org.json.JSONObject r11 = r5.getJSONObject(r10)     // Catch:{ JSONException -> 0x00bd }
            java.lang.String r4 = "deviceUrl"
            r11.remove(r4)     // Catch:{ JSONException -> 0x00bd }
            org.json.JSONObject r10 = r5.getJSONObject(r10)     // Catch:{ JSONException -> 0x00bd }
            java.lang.String r11 = "sessionUrl"
            r10.remove(r11)     // Catch:{ JSONException -> 0x00bd }
            goto L_0x00dc
        L_0x00bd:
            r10 = move-exception
            com.uxcam.internals.fz r11 = new com.uxcam.internals.fz
            r11.<init>()
            com.uxcam.internals.fz r11 = r11.a((java.lang.String) r1)
            com.uxcam.internals.fz r11 = r11.a()
            java.lang.String r1 = "try -- try { } : while removing previous data from "
            com.uxcam.internals.fz r11 = r11.a(r2, r1)
            java.lang.String r10 = r10.getMessage()
            com.uxcam.internals.fz r10 = r11.a(r0, r10)
            r10.a((int) r3)
        L_0x00dc:
            com.uxcam.internals.eq r10 = new com.uxcam.internals.eq
            com.uxcam.internals.ij r11 = r9.f13636b
            android.content.Context r11 = r11.f13639a
            r10.<init>(r11)
            java.lang.String r11 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r5)
            java.lang.String r0 = r9.f13635a
            java.lang.String r1 = "settings_"
            java.lang.StringBuilder r1 = com.uxcam.internals.hl.a(r1)
            int r0 = r0.hashCode()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r10.a((java.lang.String) r0, (java.lang.String) r11)
            return
        L_0x0100:
            com.uxcam.internals.hm r10 = com.uxcam.internals.hm.f()
            r10.f13581f = r4
            com.uxcam.internals.bi.f13067b = r4
            java.lang.String r10 = com.uxcam.internals.ij.f13637c
            com.uxcam.internals.gu$ab r10 = com.uxcam.internals.gu.a(r10)
            r11.message()
            r10.getClass()
            com.uxcam.internals.fz r10 = new com.uxcam.internals.fz
            r10.<init>()
            com.uxcam.internals.fz r10 = r10.a((java.lang.String) r1)
            com.uxcam.internals.fz r10 = r10.a()
            r10.a(r2, r7)
            java.lang.String r1 = "invokes_next"
            java.lang.String r4 = "treatAsOfflineSession()"
            r10.a(r1, r4)
            java.lang.String r1 = "200 != response.code()"
            com.uxcam.internals.fz r10 = r10.a(r2, r1)
            java.lang.String r1 = "Expected status code { 200 } but received was { "
            java.lang.StringBuilder r1 = com.uxcam.internals.hl.a(r1)
            int r11 = r11.code()
            r1.append(r11)
            java.lang.String r11 = " }"
            r1.append(r11)
            java.lang.String r11 = r1.toString()
            com.uxcam.internals.fz r10 = r10.a(r0, r11)
            r10.a((int) r3)
            com.uxcam.internals.ij r10 = r9.f13636b
            java.lang.String r11 = r9.f13635a
            r10.a((java.lang.String) r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.ii.onResponse(okhttp3.Call, okhttp3.Response):void");
    }
}

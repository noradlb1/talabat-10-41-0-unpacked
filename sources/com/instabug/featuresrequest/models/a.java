package com.instabug.featuresrequest.models;

import android.annotation.SuppressLint;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONObject;

@Instrumented
@SuppressLint({"ERADICATE_FIELD_NOT_INITIALIZED"})
public class a extends i {

    /* renamed from: d  reason: collision with root package name */
    private String f46519d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f46520e;

    /* renamed from: f  reason: collision with root package name */
    private String f46521f;

    /* renamed from: g  reason: collision with root package name */
    private String f46522g;

    /* renamed from: h  reason: collision with root package name */
    private String f46523h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f46524i = true;

    /* renamed from: j  reason: collision with root package name */
    private String f46525j;

    /* renamed from: m  reason: collision with root package name */
    public long f46526m;

    public void a(String str) {
        this.f46522g = str;
    }

    public void a(boolean z11) {
        this.f46520e = z11;
    }

    public void b(long j11) {
        this.f46526m = j11;
    }

    public void b(String str) {
        this.f46525j = str;
    }

    public void b(boolean z11) {
        this.f46524i = z11;
    }

    public String c() {
        return this.f46522g;
    }

    public void c(String str) {
        this.f46519d = str;
    }

    public String d() {
        return this.f46525j;
    }

    public void d(String str) {
        this.f46521f = str;
    }

    public String e() {
        return this.f46519d;
    }

    public void e(String str) {
        this.f46523h = str;
    }

    public String f() {
        return this.f46521f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void fromJson(java.lang.String r5) {
        /*
            r4 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>((java.lang.String) r5)
            java.lang.String r5 = "id"
            boolean r1 = r0.has(r5)
            if (r1 == 0) goto L_0x0014
            long r1 = r0.getLong(r5)
            r4.b((long) r1)
        L_0x0014:
            java.lang.String r5 = "created_at"
            boolean r1 = r0.has(r5)
            if (r1 == 0) goto L_0x0023
            long r1 = r0.getLong(r5)
            r4.a((long) r1)
        L_0x0023:
            java.lang.String r5 = "type"
            boolean r1 = r0.has(r5)
            if (r1 == 0) goto L_0x005e
            java.lang.String r5 = r0.getString(r5)
            int r1 = r5.hashCode()
            r2 = -144558306(0xfffffffff762371e, float:-4.5881914E33)
            r3 = 2
            if (r1 == r2) goto L_0x0049
            r2 = 950398559(0x38a5ee5f, float:7.912213E-5)
            if (r1 == r2) goto L_0x003f
            goto L_0x0053
        L_0x003f:
            java.lang.String r1 = "comment"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x0053
            r5 = 1
            goto L_0x0054
        L_0x0049:
            java.lang.String r1 = "state_change"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x0053
            r5 = r3
            goto L_0x0054
        L_0x0053:
            r5 = -1
        L_0x0054:
            if (r5 == r3) goto L_0x0059
            com.instabug.featuresrequest.models.h r5 = com.instabug.featuresrequest.models.h.COMMENT
            goto L_0x005b
        L_0x0059:
            com.instabug.featuresrequest.models.h r5 = com.instabug.featuresrequest.models.h.STATUS_CHANE
        L_0x005b:
            r4.a((com.instabug.featuresrequest.models.h) r5)
        L_0x005e:
            java.lang.String r5 = "uuid"
            boolean r1 = r0.has(r5)
            if (r1 == 0) goto L_0x006d
            java.lang.String r5 = r0.getString(r5)
            r4.e(r5)
        L_0x006d:
            java.lang.String r5 = "body"
            boolean r1 = r0.has(r5)
            if (r1 == 0) goto L_0x007c
            java.lang.String r5 = r0.getString(r5)
            r4.c(r5)
        L_0x007c:
            java.lang.String r5 = "admin"
            boolean r1 = r0.has(r5)
            if (r1 == 0) goto L_0x008b
            boolean r5 = r0.getBoolean(r5)
            r4.a((boolean) r5)
        L_0x008b:
            java.lang.String r5 = "commenter_name"
            boolean r1 = r0.has(r5)
            if (r1 == 0) goto L_0x009a
            java.lang.String r5 = r0.getString(r5)
            r4.d(r5)
        L_0x009a:
            java.lang.String r5 = "avatar"
            boolean r1 = r0.has(r5)
            if (r1 == 0) goto L_0x00a9
            java.lang.String r5 = r0.getString(r5)
            r4.a((java.lang.String) r5)
        L_0x00a9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.featuresrequest.models.a.fromJson(java.lang.String):void");
    }

    public long g() {
        return this.f46526m;
    }

    public String h() {
        return this.f46523h;
    }

    public boolean i() {
        return this.f46520e;
    }

    public boolean j() {
        return this.f46524i;
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", g()).put("created_at", a()).put("type", (Object) b());
        jSONObject.put("uuid", (Object) h());
        jSONObject.put("body", (Object) e());
        jSONObject.put("admin", i());
        jSONObject.put("commenter_name", (Object) f());
        jSONObject.put("avatar", (Object) c());
        return JSONObjectInstrumentation.toString(jSONObject);
    }
}

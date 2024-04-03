package com.huawei.hms.hatool;

import org.json.JSONObject;

public class l extends t {

    /* renamed from: b  reason: collision with root package name */
    private String f49060b = "";

    /* renamed from: c  reason: collision with root package name */
    private String f49061c = "";

    /* renamed from: d  reason: collision with root package name */
    private String f49062d = "";

    /* renamed from: e  reason: collision with root package name */
    private String f49063e = "";

    /* renamed from: f  reason: collision with root package name */
    protected String f49064f = "";

    /* renamed from: g  reason: collision with root package name */
    private String f49065g;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("androidid", (Object) this.f49129a);
        jSONObject.put("oaid", (Object) this.f49065g);
        jSONObject.put("uuid", (Object) this.f49064f);
        jSONObject.put("upid", (Object) this.f49063e);
        jSONObject.put("imei", (Object) this.f49060b);
        jSONObject.put("sn", (Object) this.f49061c);
        jSONObject.put("udid", (Object) this.f49062d);
        return jSONObject;
    }

    public void b(String str) {
        this.f49060b = str;
    }

    public void c(String str) {
        this.f49065g = str;
    }

    public void d(String str) {
        this.f49061c = str;
    }

    public void e(String str) {
        this.f49062d = str;
    }

    public void f(String str) {
        this.f49063e = str;
    }

    public void g(String str) {
        this.f49064f = str;
    }
}

package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.braze.models.FeatureFlag;
import org.json.JSONObject;

public class b1 implements o1 {

    /* renamed from: a  reason: collision with root package name */
    private String f48979a;

    /* renamed from: b  reason: collision with root package name */
    private String f48980b;

    /* renamed from: c  reason: collision with root package name */
    private String f48981c;

    /* renamed from: d  reason: collision with root package name */
    private String f48982d;

    /* renamed from: e  reason: collision with root package name */
    private String f48983e;

    /* renamed from: f  reason: collision with root package name */
    private String f48984f;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", (Object) this.f48979a);
        jSONObject.put("eventtime", (Object) this.f48982d);
        jSONObject.put("event", (Object) this.f48980b);
        jSONObject.put("event_session_name", (Object) this.f48983e);
        jSONObject.put("first_session_event", (Object) this.f48984f);
        if (TextUtils.isEmpty(this.f48981c)) {
            return null;
        }
        jSONObject.put(FeatureFlag.PROPERTIES, (Object) new JSONObject(this.f48981c));
        return jSONObject;
    }

    public void a(String str) {
        this.f48981c = str;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f48980b = jSONObject.optString("event");
            this.f48981c = n.a(jSONObject.optString(FeatureFlag.PROPERTIES), o0.d().a());
            this.f48979a = jSONObject.optString("type");
            this.f48982d = jSONObject.optString("eventtime");
            this.f48983e = jSONObject.optString("event_session_name");
            this.f48984f = jSONObject.optString("first_session_event");
        }
    }

    public String b() {
        return this.f48982d;
    }

    public void b(String str) {
        this.f48980b = str;
    }

    public String c() {
        return this.f48979a;
    }

    public void c(String str) {
        this.f48982d = str;
    }

    public JSONObject d() {
        JSONObject a11 = a();
        a11.put(FeatureFlag.PROPERTIES, (Object) n.b(this.f48981c, o0.d().a()));
        return a11;
    }

    public void d(String str) {
        this.f48979a = str;
    }

    public void e(String str) {
        this.f48984f = str;
    }

    public void f(String str) {
        this.f48983e = str;
    }
}

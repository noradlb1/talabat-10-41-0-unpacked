package com.instabug.featuresrequest.models;

import android.annotation.SuppressLint;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONObject;

@Instrumented
public class f extends a {
    @SuppressLint({"ERADICATE_FIELD_NOT_INITIALIZED"})

    /* renamed from: k  reason: collision with root package name */
    private String f46557k;

    /* renamed from: l  reason: collision with root package name */
    private long f46558l;

    public f(long j11, String str, String str2, String str3) {
        c(j11);
        a(System.currentTimeMillis() / 1000);
        d(str2);
        f(str3);
        c(str);
    }

    public void c(long j11) {
        this.f46558l = j11;
    }

    public void f(String str) {
        this.f46557k = str;
    }

    public void fromJson(String str) {
        super.fromJson(str);
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("email")) {
            f(jSONObject.getString("email"));
        }
        if (jSONObject.has("feature_id")) {
            c(jSONObject.getLong("feature_id"));
        }
    }

    public String k() {
        return this.f46557k;
    }

    public long l() {
        return this.f46558l;
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject(super.toJson());
        jSONObject.put("feature_id", l());
        jSONObject.put("email", (Object) k());
        return JSONObjectInstrumentation.toString(jSONObject);
    }
}

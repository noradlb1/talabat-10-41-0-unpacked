package com.instabug.library.percentagefeatures;

import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class b {

    /* renamed from: a  reason: collision with root package name */
    private double f51710a = 0.0d;

    /* renamed from: b  reason: collision with root package name */
    private double f51711b = 0.0d;

    public double a() {
        return this.f51710a;
    }

    public double b() {
        return this.f51711b;
    }

    public String c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("be_value", this.f51710a);
            jSONObject.put("sdk_value", this.f51711b);
            return JSONObjectInstrumentation.toString(jSONObject);
        } catch (JSONException unused) {
            return "";
        }
    }

    public void a(double d11) {
        this.f51710a = d11;
    }

    public void b(double d11) {
        this.f51711b = d11;
    }

    public void a(String str) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                a(jSONObject.optDouble("be_value", 0.0d));
                b(jSONObject.optDouble("sdk_value", 0.0d));
            } catch (JSONException unused) {
                a(0.0d);
                b(0.0d);
            }
        } else {
            a(0.0d);
            b(0.0d);
        }
    }
}

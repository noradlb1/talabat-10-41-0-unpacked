package com.apptimize;

import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import org.json.JSONException;
import org.json.JSONObject;

public class de extends dh {

    /* renamed from: a  reason: collision with root package name */
    private final String f41766a;

    /* renamed from: b  reason: collision with root package name */
    private final String f41767b;

    public de(String str, String str2) {
        super((JSONObject) null);
        this.f41766a = str;
        this.f41767b = str2;
    }

    public void a(JSONObject jSONObject) throws JSONException {
        super.a(jSONObject);
        jSONObject.put(AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE, (Object) this.f41766a);
        jSONObject.put("goalName", (Object) this.f41767b);
    }

    public void b(JSONObject jSONObject) throws JSONException {
        a(jSONObject);
    }

    public String toString() {
        c();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append(" GlobalStyleMetricEventAttachment  metricName:");
        String str = this.f41767b;
        String str2 = "null";
        if (str == null) {
            str = str2;
        }
        sb2.append(str);
        sb2.append(" eventType:");
        String str3 = this.f41766a;
        if (str3 != null) {
            str2 = str3;
        }
        sb2.append(str2);
        return sb2.toString();
    }

    public String b() {
        return this.f41767b;
    }

    public de(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        if (jSONObject != null) {
            this.f41766a = jSONObject.getString(AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
            this.f41767b = jSONObject.getString("goalName");
            return;
        }
        this.f41766a = null;
        this.f41767b = null;
    }

    public String a() {
        return this.f41766a;
    }
}

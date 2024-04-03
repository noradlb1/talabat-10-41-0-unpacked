package com.apptimize;

import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class dj extends dh {

    /* renamed from: a  reason: collision with root package name */
    private String f41776a;

    /* renamed from: b  reason: collision with root package name */
    private String f41777b;

    public dj(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        if (jSONObject != null) {
            this.f41776a = jSONObject.getString("goalName");
            this.f41777b = jSONObject.getString(AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
        }
    }

    public void a(JSONObject jSONObject) throws JSONException {
        super.a(jSONObject);
        jSONObject.put("goalName", (Object) this.f41776a);
        jSONObject.put(AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE, (Object) this.f41777b);
    }

    public void b(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray;
        if (jSONObject.has("metrics")) {
            jSONArray = jSONObject.getJSONArray("metrics");
        } else {
            JSONArray jSONArray2 = new JSONArray();
            jSONObject.put("metrics", (Object) jSONArray2);
            jSONArray = jSONArray2;
        }
        jSONArray.put((Object) d());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof dj)) {
            return false;
        }
        dj djVar = (dj) obj;
        if (!this.f41776a.equals(djVar.f41776a) || !this.f41777b.equals(djVar.f41777b)) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append(" VariantStyleMetricEventAttachment  metricName:");
        String str = this.f41776a;
        String str2 = "null";
        if (str == null) {
            str = str2;
        }
        sb2.append(str);
        sb2.append(" eventType:");
        String str3 = this.f41777b;
        if (str3 != null) {
            str2 = str3;
        }
        sb2.append(str2);
        return sb2.toString();
    }

    public String a() {
        return this.f41777b;
    }

    public String b() {
        return this.f41776a;
    }
}

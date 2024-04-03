package com.apptimize;

import org.json.JSONObject;

public abstract class dh extends df {
    public dh(JSONObject jSONObject) {
        super(jSONObject);
    }

    public abstract String a();

    public abstract String b();

    public String toString() {
        return super.toString() + " StyleMetricEventAttachment";
    }
}

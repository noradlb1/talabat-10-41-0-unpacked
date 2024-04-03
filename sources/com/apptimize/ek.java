package com.apptimize;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class ek implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private final long f42300a;

    /* renamed from: b  reason: collision with root package name */
    private final long f42301b;

    /* renamed from: c  reason: collision with root package name */
    private final long f42302c;

    public ek(long j11, long j12, long j13) {
        this.f42300a = j11;
        this.f42301b = j12;
        this.f42302c = j13;
    }

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("v", this.f42300a);
        jSONObject.put(c.f41585a, this.f42301b);
        jSONObject.put("p", this.f42302c);
        return jSONObject;
    }

    public long b() {
        return this.f42300a;
    }

    public long c() {
        return this.f42301b;
    }

    public long d() {
        return this.f42302c;
    }
}

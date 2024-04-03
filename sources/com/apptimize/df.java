package com.apptimize;

import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class df {

    /* renamed from: c  reason: collision with root package name */
    private static AtomicLong f41768c = new AtomicLong(1);

    /* renamed from: a  reason: collision with root package name */
    private Long f41769a;

    /* renamed from: b  reason: collision with root package name */
    private long f41770b;

    public df(JSONObject jSONObject) {
        this.f41769a = null;
        this.f41770b = 0;
        this.f41770b = f41768c.getAndIncrement();
        if (jSONObject != null) {
            try {
                this.f41769a = Long.valueOf(jSONObject.getLong("ORIGINATING_VARIANT_ID"));
            } catch (JSONException unused) {
            }
        }
        br.b("StyleAttachment originatingVariantId", this);
    }

    public void a(Long l11) {
        this.f41769a = l11;
        br.b("StyleAttachment setOriginatingVariantId", this);
    }

    public abstract void b(JSONObject jSONObject) throws JSONException;

    public Long c() {
        return this.f41769a;
    }

    public JSONObject d() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        a(jSONObject);
        return jSONObject;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("StyleAttachment(");
        sb2.append(this.f41770b);
        sb2.append("):");
        Object obj = this.f41769a;
        if (obj == null) {
            obj = "null";
        }
        sb2.append(obj);
        return sb2.toString();
    }

    public void a(JSONObject jSONObject) throws JSONException {
        Long l11 = this.f41769a;
        if (l11 != null) {
            jSONObject.put("ORIGINATING_VARIANT_ID", l11.longValue());
        }
    }
}

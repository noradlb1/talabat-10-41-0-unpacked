package com.huawei.hms.analytics.framework.c.a;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public String f47948a;

    /* renamed from: b  reason: collision with root package name */
    public String f47949b;

    /* renamed from: c  reason: collision with root package name */
    public String f47950c;

    /* renamed from: d  reason: collision with root package name */
    public String f47951d;

    /* renamed from: e  reason: collision with root package name */
    public String f47952e;

    /* renamed from: f  reason: collision with root package name */
    public String f47953f;

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("protocol_version", (Object) "1");
            jSONObject.put("compress_mode", (Object) "1");
            jSONObject.put("serviceid", (Object) this.f47953f);
            jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_APPID, (Object) this.f47949b);
            jSONObject.put("chifer", (Object) this.f47948a);
            jSONObject.put("timestamp", (Object) this.f47951d);
            jSONObject.put("servicetag", (Object) this.f47950c);
            jSONObject.put("requestid", (Object) this.f47952e);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}

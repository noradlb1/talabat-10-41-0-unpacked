package com.apptimize;

import org.json.JSONException;
import org.json.JSONObject;

public class ho extends hm<Number> {

    /* renamed from: h  reason: collision with root package name */
    private final JSONObject f42962h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f42963i;

    private ho(JSONObject jSONObject, boolean z11) {
        super("select", Number.class);
        this.f42962h = jSONObject;
        this.f42963i = z11;
    }

    public static ho a(JSONObject jSONObject) {
        return new ho(jSONObject, false);
    }

    public JSONObject b() {
        return this.f42962h;
    }

    public JSONObject a(String str) throws JSONException {
        JSONObject a11 = super.a(str);
        a11.put("options", (Object) this.f42962h);
        a11.put("multiselect", this.f42963i);
        return a11;
    }
}

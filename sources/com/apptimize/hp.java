package com.apptimize;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class hp extends hm<JSONArray> {

    /* renamed from: h  reason: collision with root package name */
    private hm<?> f42964h;

    public hp(hm<?> hmVar) {
        super("statelist", JSONArray.class);
        this.f42964h = hmVar;
    }

    public JSONObject a(String str) throws JSONException {
        JSONObject a11 = super.a(str);
        a11.put("componentType", (Object) this.f42964h.a(str));
        return a11;
    }
}

package com.apptimize;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class dz {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, Boolean> f42203a;

    public dz() {
        this.f42203a = Collections.EMPTY_MAP;
    }

    public static dz a(JSONObject jSONObject) throws JSONException {
        return new dz(fh.a(jSONObject, Boolean.class));
    }

    public Map<String, Boolean> b() {
        return this.f42203a;
    }

    public JSONObject a() throws JSONException {
        return new JSONObject((Map<?, ?>) this.f42203a);
    }

    public dz(Map<String, Boolean> map) {
        this.f42203a = Collections.unmodifiableMap(new HashMap(map));
    }
}

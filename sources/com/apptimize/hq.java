package com.apptimize;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class hq extends hm<JSONObject> {

    /* renamed from: h  reason: collision with root package name */
    private Map<String, hm<?>> f42965h;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private Map<String, hm<?>> f42966a = new HashMap();

        public a a(String str, hm<?> hmVar) {
            this.f42966a.put(str, hmVar);
            return this;
        }

        public hq a() {
            return new hq(this.f42966a);
        }
    }

    public JSONObject a(String str) throws JSONException {
        JSONObject a11 = super.a(str);
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry next : this.f42965h.entrySet()) {
            jSONObject.put((String) next.getKey(), (Object) ((hm) next.getValue()).a(str));
        }
        a11.put("summands", (Object) jSONObject);
        return a11;
    }

    private hq(Map<String, hm<?>> map) {
        super("sum", JSONObject.class);
        this.f42965h = new HashMap();
        this.f42965h = new HashMap(map);
    }
}

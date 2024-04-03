package com.apptimize;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class jl<T> implements jj<JSONObject, T> {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, jj<?, ? extends T>> f43115a;

    public jl(Map<String, jj<?, ? extends T>> map) {
        if (map.size() != 0) {
            this.f43115a = Collections.unmodifiableMap(new HashMap(map));
            return;
        }
        throw new IllegalArgumentException("Cannot create SumTransformer for empty sum");
    }

    public Class<? extends T> b() {
        return ((jj) this.f43115a.entrySet().iterator().next().getValue()).b();
    }

    private <S> T a(jj<S, ? extends T> jjVar, Object obj) throws JSONException, hk {
        Class<S> a11 = jjVar.a();
        if (a11.isInstance(obj)) {
            return jjVar.a(a11.cast(obj));
        }
        throw new JSONException("When projecting sum, expected type " + a11 + " but received " + obj);
    }

    public JSONObject a(String str, Object obj) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("tag", (Object) str);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("value", obj);
        jSONObject.put(str, (Object) jSONObject2);
        return jSONObject;
    }

    public T a(JSONObject jSONObject) throws JSONException, hk {
        String string = jSONObject.getString("tag");
        return a(this.f43115a.get(string), jSONObject.getJSONObject(string).get("value"));
    }

    public Class<JSONObject> a() {
        return JSONObject.class;
    }
}

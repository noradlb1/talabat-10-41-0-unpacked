package com.apptimize;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class jb<T> implements jj<JSONObject, T> {
    public abstract T b(int i11, int i12, int i13);

    public abstract int[] c(T t11);

    /* renamed from: d */
    public JSONObject b(T t11) throws JSONException {
        int[] c11 = c(t11);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("r", ((double) c11[0]) / 255.0d);
        jSONObject.put("g", ((double) c11[1]) / 255.0d);
        jSONObject.put("b", ((double) c11[2]) / 255.0d);
        jSONObject.put("a", ((double) c11[3]) / 255.0d);
        return jSONObject;
    }

    public T a(JSONObject jSONObject) throws JSONException {
        return b((int) ((jSONObject.getDouble("r") * 255.0d) + 0.01d), (int) ((jSONObject.getDouble("g") * 255.0d) + 0.01d), (int) ((jSONObject.getDouble("b") * 255.0d) + 0.01d));
    }

    public Class<JSONObject> a() {
        return JSONObject.class;
    }
}

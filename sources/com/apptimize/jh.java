package com.apptimize;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class jh implements jj<Number, Integer> {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f43112a;

    public jh(JSONObject jSONObject) {
        this.f43112a = jSONObject;
    }

    /* renamed from: a */
    public Number b(Integer num) {
        return num;
    }

    public Integer a(Number number) throws JSONException {
        Iterator<String> keys = this.f43112a.keys();
        while (keys.hasNext()) {
            if (this.f43112a.getInt(keys.next()) == number.intValue()) {
                return Integer.valueOf(number.intValue());
            }
        }
        throw new JSONException(String.format("Value %d is not a valid option for %s", new Object[]{Integer.valueOf(number.intValue()), this.f43112a}));
    }

    public Class<Integer> b() {
        return Integer.class;
    }

    public Class<Number> a() {
        return Number.class;
    }
}

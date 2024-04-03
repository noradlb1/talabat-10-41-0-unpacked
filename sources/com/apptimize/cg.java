package com.apptimize;

import org.json.JSONArray;
import org.json.JSONException;

public class cg {

    /* renamed from: a  reason: collision with root package name */
    private final int f41642a;

    /* renamed from: b  reason: collision with root package name */
    private final int f41643b;

    private cg(int i11, int i12) {
        this.f41642a = i11;
        this.f41643b = i12;
    }

    public static cg a(JSONArray jSONArray) throws JSONException, ca {
        if (jSONArray.length() == 2) {
            int i11 = jSONArray.getInt(0);
            int i12 = jSONArray.getInt(1);
            if (i11 <= i12) {
                return new cg(i11, i12);
            }
            throw new ca("Range start " + i11 + " greater than end " + i12);
        }
        throw new ca("Range JSON did not have exactly 2 elements");
    }

    public int b() {
        return this.f41642a;
    }

    public int c() {
        return this.f41643b;
    }

    public JSONArray a() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(this.f41642a);
        jSONArray.put(this.f41643b);
        return jSONArray;
    }
}

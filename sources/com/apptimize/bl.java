package com.apptimize;

import org.json.JSONException;
import org.json.JSONObject;

public class bl {

    /* renamed from: a  reason: collision with root package name */
    public final String f41384a;

    /* renamed from: b  reason: collision with root package name */
    public final bk f41385b;

    /* renamed from: c  reason: collision with root package name */
    public final dw f41386c;

    public bl(String str, bk bkVar, dw dwVar) {
        this.f41384a = str;
        this.f41385b = bkVar;
        this.f41386c = dwVar;
        if (str == null || bkVar == null || dwVar == null) {
            throw null;
        }
    }

    public static bl a(JSONObject jSONObject) throws JSONException {
        return new bl(jSONObject.getString("experimentName"), bk.a(jSONObject.getJSONObject("selectedVariation"), (String) null), dw.a(jSONObject.getJSONObject("metrics")));
    }
}

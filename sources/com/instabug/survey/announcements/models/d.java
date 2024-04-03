package com.instabug.survey.announcements.models;

import androidx.annotation.Nullable;
import java.io.Serializable;
import org.json.JSONObject;

public class d implements Serializable {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private String f52257a;

    @Nullable
    public static d a(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        d dVar = new d();
        dVar.a(jSONObject.optString("android"));
        return dVar;
    }

    public static JSONObject a(d dVar) {
        JSONObject jSONObject = new JSONObject();
        if (!(dVar == null || dVar.a() == null)) {
            jSONObject.put("android", (Object) dVar.a());
        }
        return jSONObject;
    }

    @Nullable
    public String a() {
        return this.f52257a;
    }

    public void a(@Nullable String str) {
        this.f52257a = str;
    }
}

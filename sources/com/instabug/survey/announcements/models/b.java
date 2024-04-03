package com.instabug.survey.announcements.models;

import androidx.annotation.Nullable;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class b implements Serializable {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private d f52247a;

    @Nullable
    public static b a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        try {
            bVar.a(d.a(jSONObject.getJSONObject("download_links")));
        } catch (JSONException unused) {
        }
        return bVar;
    }

    public static JSONObject a(@Nullable b bVar) {
        JSONObject jSONObject = new JSONObject();
        if (!(bVar == null || bVar.a() == null)) {
            jSONObject.put("download_links", (Object) d.a(bVar.a()));
        }
        return jSONObject;
    }

    @Nullable
    public d a() {
        return this.f52247a;
    }

    public void a(@Nullable d dVar) {
        this.f52247a = dVar;
    }
}

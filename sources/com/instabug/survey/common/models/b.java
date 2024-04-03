package com.instabug.survey.common.models;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class b implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private boolean f52335a = false;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private List f52336b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private String f52337c;

    @Nullable
    public String a() {
        return this.f52337c;
    }

    public void a(@Nullable String str) {
        this.f52337c = str;
    }

    public void a(@NonNull List list) {
        this.f52336b = list;
    }

    public void a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            arrayList.add(jSONArray.getString(i11));
        }
        a((List) arrayList);
    }

    public void a(JSONObject jSONObject) {
        a(jSONObject.optBoolean("localized", false));
        a(jSONObject.optString("current_locale"));
        if (jSONObject.has("locales")) {
            a(jSONObject.getJSONArray("locales"));
        }
    }

    public void a(boolean z11) {
        this.f52335a = z11;
    }

    @NonNull
    public List b() {
        List list = this.f52336b;
        return list == null ? Collections.emptyList() : list;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject != null) {
            jSONObject.put("localized", this.f52335a);
            List list = this.f52336b;
            if (list != null) {
                jSONObject.put("locales", (Object) list);
            }
            String str = this.f52337c;
            if (str != null) {
                jSONObject.put("current_locale", (Object) str);
            }
        }
    }

    public boolean c() {
        return this.f52335a;
    }
}

package com.instabug.survey.common.models;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.internal.storage.cache.Cacheable;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

@Instrumented
public class c implements Cacheable, Serializable {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private String f52338a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private String f52339b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private String f52340c;

    public static ArrayList a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            c cVar = new c();
            JSONObject jSONObject = jSONArray.getJSONObject(i11);
            cVar.fromJson(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
            arrayList.add(cVar);
        }
        return arrayList;
    }

    public static JSONArray a(ArrayList arrayList) {
        JSONArray jSONArray = new JSONArray();
        if (arrayList != null) {
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                jSONArray.put((Object) new JSONObject(((c) arrayList.get(i11)).toJson()));
            }
        }
        return jSONArray;
    }

    public c a(String str) {
        this.f52338a = str;
        return this;
    }

    @Nullable
    public String a() {
        return this.f52338a;
    }

    public c b(String str) {
        this.f52340c = str;
        return this;
    }

    @Nullable
    public String b() {
        return this.f52340c;
    }

    public c c(String str) {
        this.f52339b = str;
        return this;
    }

    @Nullable
    public String c() {
        return this.f52339b;
    }

    public void fromJson(String str) {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("key")) {
            a(jSONObject.getString("key"));
        }
        if (jSONObject.has("value")) {
            c(jSONObject.getString("value"));
        }
        if (jSONObject.has("operator")) {
            b(jSONObject.getString("operator"));
        }
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("key", (Object) a()).put("value", (Object) this.f52339b).put("operator", (Object) this.f52340c);
        return JSONObjectInstrumentation.toString(jSONObject);
    }

    @NonNull
    public String toString() {
        return "(key: " + this.f52338a + ") " + this.f52340c + " (value: " + this.f52339b + ")";
    }
}

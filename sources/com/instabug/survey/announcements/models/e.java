package com.instabug.survey.announcements.models;

import androidx.annotation.Nullable;
import com.instabug.library.internal.storage.cache.Cacheable;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

@Instrumented
public class e implements Serializable, Cacheable {

    /* renamed from: a  reason: collision with root package name */
    private long f52258a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private String f52259b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private String f52260c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private String f52261d;

    private e() {
    }

    public static ArrayList a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i11);
            e eVar = new e();
            eVar.fromJson(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
            arrayList.add(eVar);
        }
        return arrayList;
    }

    public static JSONArray a(@Nullable ArrayList arrayList) {
        JSONArray jSONArray = new JSONArray();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                jSONArray.put((Object) new JSONObject(((e) it.next()).toJson()));
            }
        }
        return jSONArray;
    }

    private void b(@Nullable String str) {
        this.f52261d = str;
    }

    @Nullable
    public String a() {
        return this.f52260c;
    }

    public void a(long j11) {
        this.f52258a = j11;
    }

    public void a(@Nullable String str) {
        this.f52260c = str;
    }

    @Nullable
    public String b() {
        return this.f52261d;
    }

    public long c() {
        return this.f52258a;
    }

    public void c(@Nullable String str) {
        this.f52259b = str;
    }

    @Nullable
    public String d() {
        return this.f52259b;
    }

    public void fromJson(String str) {
        JSONObject jSONObject = new JSONObject(str);
        a(jSONObject.has("id") ? jSONObject.getLong("id") : -1);
        if (jSONObject.has("title")) {
            c(jSONObject.getString("title"));
        }
        if (jSONObject.has("description")) {
            a(jSONObject.getString("description"));
        }
        b(jSONObject.optString("icon_url", ""));
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", c()).put("title", (Object) this.f52259b).put("description", (Object) this.f52260c).put("icon_url", (Object) this.f52261d);
        return JSONObjectInstrumentation.toString(jSONObject);
    }
}

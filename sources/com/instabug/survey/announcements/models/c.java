package com.instabug.survey.announcements.models;

import androidx.annotation.Nullable;
import com.instabug.library.internal.storage.cache.Cacheable;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@Instrumented
public class c implements Serializable, Cacheable {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private String f52248a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private String f52249b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private String f52250c;

    /* renamed from: d  reason: collision with root package name */
    private long f52251d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private ArrayList f52252e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private ArrayList f52253f;

    /* renamed from: g  reason: collision with root package name */
    private int f52254g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f52255h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private b f52256i;

    public static ArrayList a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i11);
                c cVar = new c();
                cVar.fromJson(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public static JSONArray c(@Nullable ArrayList arrayList) {
        JSONArray jSONArray = new JSONArray();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                jSONArray.put((Object) new JSONObject(((c) it.next()).toJson()));
            }
        }
        return jSONArray;
    }

    @Nullable
    public b a() {
        return this.f52256i;
    }

    public void a(int i11) {
        this.f52254g = i11;
    }

    public void a(long j11) {
        this.f52251d = j11;
    }

    public void a(@Nullable b bVar) {
        this.f52256i = bVar;
    }

    public void a(@Nullable String str) {
        this.f52250c = str;
    }

    public void a(@Nullable ArrayList arrayList) {
        this.f52252e = arrayList;
    }

    @Nullable
    public String b() {
        return this.f52250c;
    }

    public void b(@Nullable String str) {
        this.f52249b = str;
    }

    public void b(@Nullable ArrayList arrayList) {
        this.f52253f = arrayList;
    }

    @Nullable
    public String c() {
        return this.f52249b;
    }

    public void c(@Nullable String str) {
        this.f52248a = str;
    }

    public long d() {
        return this.f52251d;
    }

    @Nullable
    public ArrayList e() {
        return this.f52252e;
    }

    @Nullable
    public List f() {
        return this.f52253f;
    }

    public void fromJson(String str) {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("id")) {
            a(jSONObject.getLong("id"));
        }
        if (jSONObject.has("title")) {
            c(jSONObject.getString("title"));
        }
        if (jSONObject.has("description")) {
            b(jSONObject.getString("description"));
        }
        if (jSONObject.has("options")) {
            JSONArray jSONArray = jSONObject.getJSONArray("options");
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                arrayList.add(jSONArray.getString(i11));
            }
            b(arrayList);
        }
        if (jSONObject.has("features")) {
            a(e.a(jSONObject.getJSONArray("features")));
        }
        if (jSONObject.has("type")) {
            a(jSONObject.getInt("type"));
        }
        if (jSONObject.has("answer")) {
            a(jSONObject.getString("answer"));
        }
        if (jSONObject.has(DarkstoresMainActivity.CONFIG_EXTRA_KEY)) {
            a(b.a(jSONObject.getJSONObject(DarkstoresMainActivity.CONFIG_EXTRA_KEY)));
        }
    }

    @Nullable
    public String g() {
        return this.f52248a;
    }

    public int h() {
        return this.f52254g;
    }

    public String i() {
        int i11 = this.f52254g;
        return i11 != 100 ? i11 != 101 ? "" : "UpdateMessage" : "WhatsNew";
    }

    public boolean j() {
        return this.f52255h;
    }

    public void k() {
        this.f52255h = true;
        if (e() != null) {
            Iterator it = e().iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                if (eVar.b() != null && !eVar.b().equals("")) {
                    this.f52255h = false;
                }
            }
        }
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        String str = "";
        JSONObject put = jSONObject.put("id", d()).put("title", (Object) g() != null ? g() : str).put("options", (Object) f() != null ? new JSONArray((Collection<?>) f()) : new JSONArray()).put("features", (Object) e.a(e())).put("type", h()).put("answer", (Object) b() != null ? b() : str);
        if (c() != null) {
            str = c();
        }
        put.put("description", (Object) str).put("type", h()).put(DarkstoresMainActivity.CONFIG_EXTRA_KEY, (Object) b.a(a()));
        return JSONObjectInstrumentation.toString(jSONObject);
    }
}

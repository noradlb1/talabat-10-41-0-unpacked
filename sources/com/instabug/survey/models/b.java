package com.instabug.survey.models;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.instabug.library.internal.storage.cache.Cacheable;
import com.instabug.library.util.TimeUtils;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

@Instrumented
public class b implements Cacheable, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private long f52396a = -1;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private String f52397b;

    /* renamed from: c  reason: collision with root package name */
    private int f52398c = -1;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private ArrayList f52399d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private String f52400e;

    /* renamed from: f  reason: collision with root package name */
    private long f52401f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f52402g = true;

    public static ArrayList a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                b bVar = new b();
                JSONObject jSONObject = jSONArray.getJSONObject(i11);
                bVar.fromJson(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    private void a(long j11) {
        this.f52401f = j11;
    }

    public static JSONArray b(ArrayList arrayList) {
        JSONArray jSONArray = new JSONArray();
        if (arrayList != null) {
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                jSONArray.put((Object) new JSONObject(((b) arrayList.get(i11)).toJson()));
            }
        }
        return jSONArray;
    }

    @Nullable
    public String a() {
        return this.f52400e;
    }

    public void a(int i11) {
        this.f52398c = i11;
    }

    public void a(@Nullable String str) {
        this.f52400e = str;
        if (str != null && !TextUtils.isEmpty(str)) {
            a(TimeUtils.currentTimeSeconds());
        }
    }

    public void a(@Nullable ArrayList arrayList) {
        this.f52399d = arrayList;
    }

    public void a(boolean z11) {
        this.f52402g = z11;
    }

    public long b() {
        return this.f52401f;
    }

    public void b(long j11) {
        this.f52396a = j11;
    }

    public void b(@Nullable String str) {
        this.f52397b = str;
    }

    public long c() {
        return this.f52396a;
    }

    @Nullable
    public ArrayList d() {
        return this.f52399d;
    }

    @Nullable
    public String e() {
        return this.f52397b;
    }

    public int f() {
        return this.f52398c;
    }

    public void fromJson(String str) {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("id")) {
            b(jSONObject.getLong("id"));
        }
        if (jSONObject.has("title")) {
            b(jSONObject.getString("title"));
        }
        if (jSONObject.has("type")) {
            a(jSONObject.getInt("type"));
        }
        if (jSONObject.has("options")) {
            JSONArray jSONArray = jSONObject.getJSONArray("options");
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                arrayList.add(String.valueOf(jSONArray.get(i11)));
            }
            a(arrayList);
        }
        if (jSONObject.has("answer")) {
            a(jSONObject.getString("answer"));
        }
        if (jSONObject.has("answered_at")) {
            a(jSONObject.getLong("answered_at"));
        }
        if (jSONObject.has("enabled")) {
            a(jSONObject.getBoolean("enabled"));
        }
    }

    public String g() {
        int i11 = this.f52398c;
        return i11 != 0 ? i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? i11 != 5 ? "" : "Alert" : "AppStoreRating" : "NPS" : "StarRating" : "MCQ" : "Textfield";
    }

    public boolean h() {
        return this.f52402g;
    }

    public void i() {
        this.f52400e = null;
        a(0);
    }

    public String toJson() {
        JSONArray jSONArray;
        JSONObject jSONObject = new JSONObject();
        JSONObject put = jSONObject.put("id", c()).put("title", (Object) e()).put("type", f());
        ArrayList arrayList = this.f52399d;
        if (arrayList == null) {
            jSONArray = new JSONArray();
        }
        put.put("options", (Object) jSONArray).put("answer", (Object) a() != null ? a() : "").put("answered_at", b()).put("enabled", h());
        return JSONObjectInstrumentation.toString(jSONObject);
    }
}

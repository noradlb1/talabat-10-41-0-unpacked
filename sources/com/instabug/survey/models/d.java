package com.instabug.survey.models;

import android.os.Parcel;
import androidx.annotation.Nullable;
import com.instabug.library.internal.storage.cache.Cacheable;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

@Instrumented
public class d implements Cacheable, Serializable {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private String f52403a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private String f52404b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private String f52405c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private String f52406d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f52407e;

    static {
        new c();
    }

    public d() {
    }

    public d(Parcel parcel) {
        this.f52403a = parcel.readString();
        this.f52404b = parcel.readString();
        this.f52405c = parcel.readString();
        this.f52406d = parcel.readString();
        this.f52407e = parcel.readByte() != 0;
    }

    public static ArrayList a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                d dVar = new d();
                JSONObject jSONObject = jSONArray.getJSONObject(i11);
                dVar.fromJson(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
                arrayList.add(dVar);
            }
        }
        return arrayList;
    }

    public static JSONArray a(ArrayList arrayList) {
        JSONArray jSONArray = new JSONArray();
        if (arrayList != null) {
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                jSONArray.put((Object) new JSONObject(((d) arrayList.get(i11)).toJson()));
            }
        }
        return jSONArray;
    }

    @Nullable
    public String a() {
        return this.f52406d;
    }

    public void a(@Nullable String str) {
        this.f52406d = str;
    }

    public void a(boolean z11) {
        this.f52407e = z11;
    }

    @Nullable
    public String b() {
        return this.f52405c;
    }

    public void b(@Nullable String str) {
        this.f52403a = str;
    }

    @Nullable
    public String c() {
        return this.f52404b;
    }

    public void c(@Nullable String str) {
        this.f52405c = str;
    }

    public void d(@Nullable String str) {
        this.f52404b = str;
    }

    public boolean d() {
        return this.f52407e;
    }

    public void fromJson(String str) {
        JSONObject jSONObject = new JSONObject(str);
        d(jSONObject.optString("title"));
        c(jSONObject.optString("message"));
        a(jSONObject.optString("call_to_action"));
        b(jSONObject.optString("user_class"));
        a(jSONObject.optBoolean("appstore_enabled", false));
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        String str = this.f52404b;
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        jSONObject.put("title", (Object) str);
        String str3 = this.f52405c;
        if (str3 == null) {
            str3 = str2;
        }
        jSONObject.put("message", (Object) str3);
        String str4 = this.f52403a;
        if (str4 == null) {
            str4 = str2;
        }
        jSONObject.put("user_class", (Object) str4);
        String str5 = this.f52406d;
        if (str5 != null) {
            str2 = str5;
        }
        jSONObject.put("call_to_action", (Object) str2);
        jSONObject.put("appstore_enabled", this.f52407e);
        return JSONObjectInstrumentation.toString(jSONObject);
    }
}

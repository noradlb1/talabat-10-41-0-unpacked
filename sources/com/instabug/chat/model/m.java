package com.instabug.chat.model;

import android.annotation.SuppressLint;
import com.instabug.library.internal.storage.cache.Cacheable;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

@Instrumented
@SuppressLint({"ERADICATE_FIELD_NOT_INITIALIZED"})
public class m implements Cacheable {

    /* renamed from: a  reason: collision with root package name */
    private l f46077a;

    /* renamed from: b  reason: collision with root package name */
    private String f46078b;

    /* renamed from: c  reason: collision with root package name */
    private String f46079c;

    public static ArrayList a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            m mVar = new m();
            mVar.fromJson(jSONArray.getString(i11));
            arrayList.add(mVar);
        }
        return arrayList;
    }

    public static JSONArray a(ArrayList arrayList) {
        JSONArray jSONArray = new JSONArray();
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            jSONArray.put((Object) ((m) arrayList.get(i11)).toJson());
        }
        return jSONArray;
    }

    public String a() {
        return this.f46078b;
    }

    public void a(l lVar) {
        this.f46077a = lVar;
    }

    public void a(String str) {
        this.f46078b = str;
    }

    public l b() {
        return this.f46077a;
    }

    public void b(String str) {
        this.f46079c = str;
    }

    public String c() {
        return this.f46079c;
    }

    @SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_PARAMETER_ANNOTATION"})
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return String.valueOf(mVar.a()).equals(String.valueOf(a())) && String.valueOf(mVar.c()).equals(String.valueOf(c())) && mVar.b() == b();
    }

    public void fromJson(String str) {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("url")) {
            b(jSONObject.getString("url"));
        }
        if (jSONObject.has("title")) {
            a(jSONObject.getString("title"));
        }
        if (jSONObject.has("type")) {
            String string = jSONObject.getString("type");
            string.hashCode();
            a(!string.equals("button") ? l.NOT_AVAILABLE : l.BUTTON);
        }
    }

    public int hashCode() {
        if (a() == null || c() == null || b() == null) {
            return -1;
        }
        return (String.valueOf(a().hashCode()) + String.valueOf(c().hashCode()) + String.valueOf(b().toString().hashCode())).hashCode();
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", (Object) this.f46077a.toString());
        jSONObject.put("title", (Object) this.f46078b);
        jSONObject.put("url", (Object) this.f46079c);
        return JSONObjectInstrumentation.toString(jSONObject);
    }

    public String toString() {
        return "Type: " + b() + ", title: " + a() + ", url: " + c();
    }
}

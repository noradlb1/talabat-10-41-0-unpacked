package com.apptimize;

import com.braze.models.FeatureFlag;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class di extends df {

    /* renamed from: a  reason: collision with root package name */
    public final String f41772a;

    /* renamed from: b  reason: collision with root package name */
    public final String f41773b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f41774c;

    /* renamed from: d  reason: collision with root package name */
    private final JSONObject f41775d;

    public static class a extends df {
        public a(JSONObject jSONObject) {
            super(jSONObject);
        }

        public static boolean c(JSONObject jSONObject) {
            if (jSONObject == null || jSONObject.opt("variantIdProperty") == null) {
                return false;
            }
            return true;
        }

        public void a(JSONObject jSONObject) throws JSONException {
            super.a(jSONObject);
            jSONObject.put("variantIdProperty", (Object) "true");
        }

        public void b(JSONObject jSONObject) throws JSONException {
            JSONArray jSONArray;
            if (jSONObject.has(FeatureFlag.PROPERTIES)) {
                jSONArray = jSONObject.getJSONArray(FeatureFlag.PROPERTIES);
            } else {
                JSONArray jSONArray2 = new JSONArray();
                jSONObject.put(FeatureFlag.PROPERTIES, (Object) jSONArray2);
                jSONArray = jSONArray2;
            }
            if (c() != null) {
                jSONArray.put((Object) d());
            }
        }

        public String toString() {
            return super.toString() + " StyleVariantIdPropertyAttachment";
        }
    }

    public di(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        if (jSONObject != null) {
            this.f41772a = jSONObject.getString("property");
            this.f41773b = jSONObject.getString("type");
            this.f41774c = jSONObject.get("value");
            this.f41775d = jSONObject.optJSONObject("constraint");
            return;
        }
        this.f41772a = null;
        this.f41773b = null;
        this.f41774c = null;
        this.f41775d = null;
    }

    public void a(JSONObject jSONObject) throws JSONException {
        super.a(jSONObject);
        jSONObject.put("property", (Object) this.f41772a);
        jSONObject.put("type", (Object) this.f41773b);
        jSONObject.put("value", this.f41774c);
        JSONObject jSONObject2 = this.f41775d;
        if (jSONObject2 != null) {
            jSONObject.put("constraint", (Object) jSONObject2);
        }
    }

    public void b(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray;
        if (jSONObject.has(FeatureFlag.PROPERTIES)) {
            jSONArray = jSONObject.getJSONArray(FeatureFlag.PROPERTIES);
        } else {
            JSONArray jSONArray2 = new JSONArray();
            jSONObject.put(FeatureFlag.PROPERTIES, (Object) jSONArray2);
            jSONArray = jSONArray2;
        }
        jSONArray.put((Object) d());
    }

    public Object e() {
        return this.f41774c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof di)) {
            return false;
        }
        di diVar = (di) obj;
        if (!diVar.f41772a.equals(this.f41772a) || !diVar.f41773b.equals(this.f41773b) || !diVar.f41774c.equals(this.f41774c)) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append(" StylePropertyAttachment  name:");
        String str = this.f41772a;
        String str2 = "null";
        if (str == null) {
            str = str2;
        }
        sb2.append(str);
        sb2.append(" type:");
        String str3 = this.f41773b;
        if (str3 == null) {
            str3 = str2;
        }
        sb2.append(str3);
        sb2.append(" value:");
        Object obj = this.f41774c;
        if (obj != null) {
            str2 = obj.toString();
        }
        sb2.append(str2);
        return sb2.toString();
    }

    public String b() {
        return this.f41773b;
    }

    public String a() {
        return this.f41772a;
    }
}

package com.apptimize;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import org.json.JSONException;
import org.json.JSONObject;

public class hm<S> {

    /* renamed from: a  reason: collision with root package name */
    public static final hm<JSONObject> f42952a;

    /* renamed from: b  reason: collision with root package name */
    public static final hm<Number> f42953b;

    /* renamed from: c  reason: collision with root package name */
    public static final hm<Number> f42954c;

    /* renamed from: d  reason: collision with root package name */
    public static final hm<JSONObject> f42955d;

    /* renamed from: e  reason: collision with root package name */
    public static final hm<String> f42956e = a("text", String.class);

    /* renamed from: f  reason: collision with root package name */
    public static final hm<Boolean> f42957f = a(TypedValues.Custom.S_BOOLEAN, Boolean.class);

    /* renamed from: g  reason: collision with root package name */
    public static final hm<Void> f42958g = a("null", Void.class);

    /* renamed from: h  reason: collision with root package name */
    private final String f42959h;

    /* renamed from: i  reason: collision with root package name */
    private final Class<S> f42960i;

    static {
        Class<JSONObject> cls = JSONObject.class;
        f42952a = a("color", cls);
        Class<Number> cls2 = Number.class;
        f42953b = a(TypedValues.Custom.S_FLOAT, cls2);
        f42954c = a("int", cls2);
        f42955d = a("image", cls);
    }

    public hm(String str, Class<S> cls) {
        this.f42959h = str;
        this.f42960i = cls;
    }

    public static <S> hm<S> a(String str, Class<S> cls) {
        return new hm<>(str, cls);
    }

    public Class<S> a() {
        return this.f42960i;
    }

    public JSONObject a(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", (Object) this.f42959h);
        jSONObject.put("name", (Object) str);
        return jSONObject;
    }

    public JSONObject a(String str, S s11) throws JSONException {
        JSONObject a11 = a(str);
        a11.put("value", (Object) s11);
        return a11;
    }
}

package com.instabug.survey.common.models;

import com.instabug.library.internal.storage.cache.Cacheable;
import com.instabug.library.model.session.SessionParameter;
import com.instabug.library.util.filters.Filters;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONObject;

@Instrumented
public class g implements Cacheable, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList f52348a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private ArrayList f52349b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private ArrayList f52350c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private ArrayList f52351d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private h f52352e = new h();

    /* renamed from: f  reason: collision with root package name */
    private d f52353f = new d();

    /* renamed from: g  reason: collision with root package name */
    private String f52354g = "and";

    public static g a(String str) {
        g gVar = new g();
        gVar.fromJson(str);
        return gVar;
    }

    public static JSONObject a(g gVar) {
        return new JSONObject(gVar.toJson());
    }

    public ArrayList a() {
        return this.f52351d;
    }

    public void a(d dVar) {
        this.f52353f = dVar;
    }

    public void a(h hVar) {
        this.f52352e = hVar;
    }

    public void a(ArrayList arrayList) {
        this.f52351d = arrayList;
    }

    public String b() {
        return this.f52354g;
    }

    public void b(String str) {
        this.f52354g = str;
    }

    public void b(ArrayList arrayList) {
        this.f52349b = arrayList;
    }

    public ArrayList c() {
        return this.f52349b;
    }

    public void c(ArrayList arrayList) {
        this.f52348a = arrayList;
    }

    public d d() {
        return this.f52353f;
    }

    public void d(ArrayList arrayList) {
        this.f52350c = arrayList;
    }

    public ArrayList e() {
        return (ArrayList) Filters.applyOn(this.f52348a).apply(com.instabug.survey.utils.g.a()).thenGet();
    }

    public h f() {
        return this.f52352e;
    }

    public void fromJson(String str) {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("primitive_types")) {
            c(c.a(jSONObject.getJSONArray("primitive_types")));
        }
        if (jSONObject.has(SessionParameter.CUSTOM_ATTRIBUTES)) {
            b(c.a(jSONObject.getJSONArray(SessionParameter.CUSTOM_ATTRIBUTES)));
        }
        if (jSONObject.has("user_events")) {
            d(c.a(jSONObject.getJSONArray("user_events")));
        }
        if (jSONObject.has("events")) {
            a(a.a(jSONObject.getJSONArray("events")));
        }
        if (jSONObject.has("operator")) {
            b(jSONObject.getString("operator"));
        }
        if (jSONObject.has("trigger")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("trigger");
            a(h.b(!(jSONObject2 instanceof JSONObject) ? jSONObject2.toString() : JSONObjectInstrumentation.toString(jSONObject2)));
        }
        if (jSONObject.has("frequency")) {
            JSONObject jSONObject3 = jSONObject.getJSONObject("frequency");
            a(d.b(!(jSONObject3 instanceof JSONObject) ? jSONObject3.toString() : JSONObjectInstrumentation.toString(jSONObject3)));
        }
    }

    public ArrayList g() {
        return this.f52350c;
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("primitive_types", (Object) c.a(this.f52348a)).put(SessionParameter.CUSTOM_ATTRIBUTES, (Object) c.a(this.f52349b)).put("user_events", (Object) c.a(this.f52350c)).put("events", (Object) a.a(this.f52351d)).put("trigger", (Object) this.f52352e.c()).put("frequency", (Object) this.f52353f.g()).put("operator", (Object) b());
        return JSONObjectInstrumentation.toString(jSONObject);
    }
}

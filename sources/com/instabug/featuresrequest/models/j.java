package com.instabug.featuresrequest.models;

import android.annotation.SuppressLint;
import com.instabug.library.internal.storage.cache.Cacheable;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONObject;

@Instrumented
@SuppressLint({"ERADICATE_FIELD_NOT_INITIALIZED"})
public class j implements Cacheable, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private long f46569a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList f46570b;

    public static j a(JSONObject jSONObject) {
        j jVar = new j();
        jVar.fromJson(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
        return jVar;
    }

    public long a() {
        return this.f46569a;
    }

    public void a(long j11) {
        this.f46569a = j11;
    }

    public void a(ArrayList arrayList) {
        this.f46570b = arrayList;
    }

    public ArrayList b() {
        return this.f46570b;
    }

    public void fromJson(String str) {
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("featureId")) {
            a(jSONObject.getLong("featureId"));
        }
        if (jSONObject.has("timeline")) {
            a(i.a(jSONObject.getJSONArray("timeline")));
        }
    }

    public String toJson() {
        JSONObject put = new JSONObject().put("featureId", a()).put("timeline", (Object) i.a(b()));
        return !(put instanceof JSONObject) ? put.toString() : JSONObjectInstrumentation.toString(put);
    }
}

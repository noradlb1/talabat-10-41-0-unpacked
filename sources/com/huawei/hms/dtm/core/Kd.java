package com.huawei.hms.dtm.core;

import android.util.Log;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.talabat.fluid.homescreen.presentation.viewmodel.FluidHomeScreenViewModel;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class Kd {

    /* renamed from: a  reason: collision with root package name */
    private String f48330a;

    /* renamed from: b  reason: collision with root package name */
    private a f48331b;

    /* renamed from: c  reason: collision with root package name */
    private String f48332c;

    /* renamed from: d  reason: collision with root package name */
    private Md f48333d;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final float f48334a;

        /* renamed from: b  reason: collision with root package name */
        private float f48335b;

        /* renamed from: c  reason: collision with root package name */
        private float f48336c;

        public a(float f11) {
            this.f48334a = f11;
        }

        public a a(float f11) {
            this.f48336c = f11 * this.f48334a;
            return this;
        }

        public void a(JSONObject jSONObject) throws JSONException {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("w", (double) this.f48335b);
            jSONObject2.put("h", (double) this.f48336c);
            jSONObject.put("screen", (Object) jSONObject2);
        }

        public a b(float f11) {
            this.f48335b = f11 * this.f48334a;
            return this;
        }
    }

    public Kd a(a aVar) {
        this.f48331b = aVar;
        return this;
    }

    public Kd a(Md md2) {
        this.f48333d = md2;
        return this;
    }

    public Kd a(String str) {
        this.f48330a = str;
        return this;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("image", (Object) this.f48330a);
            jSONObject.put("pageId", (Object) this.f48332c);
            a aVar = this.f48331b;
            if (aVar != null) {
                aVar.a(jSONObject);
            }
            Md md2 = this.f48333d;
            if (md2 != null) {
                jSONObject.put(FluidHomeScreenViewModel.METADATA_COMPONENT_KEY, (Object) md2.a(jSONObject));
                this.f48333d.a(jSONObject);
            }
        } catch (JSONException e11) {
            Log.w("DTM-AutoTrace", "JSONException#" + e11.getMessage());
        }
        return jSONObject;
    }

    public Kd b(String str) {
        this.f48332c = str;
        return this;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Kd)) {
            return false;
        }
        Kd kd2 = (Kd) obj;
        JSONObject a11 = a();
        String jSONObject = !(a11 instanceof JSONObject) ? a11.toString() : JSONObjectInstrumentation.toString(a11);
        JSONObject a12 = kd2.a();
        return jSONObject.equals(!(a12 instanceof JSONObject) ? a12.toString() : JSONObjectInstrumentation.toString(a12));
    }

    public int hashCode() {
        JSONObject a11 = a();
        return (!(a11 instanceof JSONObject) ? a11.toString() : JSONObjectInstrumentation.toString(a11)).hashCode();
    }
}

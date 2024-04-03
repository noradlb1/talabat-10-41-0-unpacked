package com.apptimize;

import com.newrelic.agent.android.distributedtracing.DistributedTracing;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class ck {

    public static class a extends ck {

        /* renamed from: a  reason: collision with root package name */
        private String f41680a;

        public JSONObject a() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", (Object) "constant");
            jSONObject.put("value", (Object) this.f41680a);
            return jSONObject;
        }

        public String b() {
            return this.f41680a;
        }

        private a(String str) {
            this.f41680a = str;
        }
    }

    public static class b extends ck {
        public JSONObject a() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", (Object) DistributedTracing.NR_GUID_ATTRIBUTE);
            return jSONObject;
        }
    }

    public static class c extends ck {

        /* renamed from: a  reason: collision with root package name */
        private JSONObject f41681a;

        public JSONObject a() {
            return this.f41681a;
        }

        private c(JSONObject jSONObject) {
            this.f41681a = jSONObject;
        }
    }

    public static ck a(JSONObject jSONObject) throws JSONException {
        String string = jSONObject.getString("type");
        if ("constant".equals(string)) {
            return new a(jSONObject.getString("value"));
        }
        if (DistributedTracing.NR_GUID_ATTRIBUTE.equals(string)) {
            return new b();
        }
        return new c(jSONObject);
    }

    public abstract JSONObject a() throws JSONException;
}

package com.apptimize;

import com.newrelic.agent.android.agentdata.HexAttribute;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class bk {

    /* renamed from: a  reason: collision with root package name */
    private final long f41377a;

    /* renamed from: b  reason: collision with root package name */
    private final double f41378b;

    public static class a extends bk {

        /* renamed from: a  reason: collision with root package name */
        private final Double f41379a;

        public a(long j11, double d11, Double d12) {
            super(j11, d11);
            this.f41379a = d12;
        }

        public Double b() {
            return this.f41379a;
        }
    }

    public static class b extends bk {

        /* renamed from: a  reason: collision with root package name */
        private final Integer f41380a;

        public b(long j11, double d11, Integer num) {
            super(j11, d11);
            this.f41380a = num;
        }

        public Integer b() {
            return this.f41380a;
        }
    }

    public static class c extends bk {

        /* renamed from: a  reason: collision with root package name */
        private final String f41381a;

        public c(long j11, double d11, String str) {
            super(j11, d11);
            this.f41381a = str;
        }

        public String b() {
            return this.f41381a;
        }
    }

    public static class d extends bk {

        /* renamed from: a  reason: collision with root package name */
        private final String f41382a;

        public d(long j11, double d11, String str) {
            super(j11, d11);
            this.f41382a = str;
        }

        public String b() {
            return this.f41382a;
        }
    }

    public static class e extends bk {

        /* renamed from: a  reason: collision with root package name */
        private List<bn> f41383a;

        public e(long j11, double d11, List<bn> list) {
            super(j11, d11);
            this.f41383a = list;
        }

        public List<bn> b() {
            return Collections.unmodifiableList(this.f41383a);
        }
    }

    public long a() {
        return this.f41377a;
    }

    private bk(long j11, double d11) {
        this.f41377a = j11;
        this.f41378b = d11;
    }

    public static bk a(JSONObject jSONObject, String str) throws JSONException {
        if (str == null) {
            str = jSONObject.getString("type");
        }
        long j11 = jSONObject.getLong("id");
        double d11 = jSONObject.getDouble("weight");
        if ("programmatic".equals(str)) {
            return new c(j11, d11, jSONObject.getString(HexAttribute.HEX_ATTR_METHOD_NAME));
        }
        if ("string-value".equals(str)) {
            return new d(j11, d11, !jSONObject.isNull("value") ? jSONObject.getString("value") : null);
        } else if ("int-value".equals(str)) {
            return new b(j11, d11, !jSONObject.isNull("value") ? Integer.valueOf(jSONObject.getInt("value")) : null);
        } else if ("double-value".equals(str)) {
            return new a(j11, d11, !jSONObject.isNull("value") ? Double.valueOf(jSONObject.getDouble("value")) : null);
        } else if ("wysiwyg".equals(str)) {
            JSONArray optJSONArray = jSONObject.optJSONArray("wysiwygData");
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            return new e(j11, d11, bn.a(optJSONArray));
        } else {
            throw new JSONException("Type not valid");
        }
    }
}

package com.apptimize;

import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class cn implements bw, cs {

    /* renamed from: a  reason: collision with root package name */
    private final String f41700a;

    /* renamed from: b  reason: collision with root package name */
    private final String f41701b;

    /* renamed from: c  reason: collision with root package name */
    private final bv f41702c;

    /* renamed from: d  reason: collision with root package name */
    private final cf f41703d;

    /* renamed from: e  reason: collision with root package name */
    private final List<db> f41704e;

    public cn(String str, String str2, bv bvVar, cf cfVar, List<db> list) {
        this.f41700a = str;
        this.f41701b = str2;
        this.f41702c = bvVar;
        this.f41703d = cfVar;
        this.f41704e = Collections.unmodifiableList(list);
    }

    public static cn a(JSONObject jSONObject, au auVar) throws JSONException, ca {
        String optString = jSONObject.optString("metricName");
        if (optString == null || "".equals(optString)) {
            optString = "Unknown metric name";
        }
        String str = optString;
        String optString2 = jSONObject.optString(AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
        if (optString2 == null || "".equals(optString2)) {
            optString2 = "Unknown event type";
        }
        String str2 = optString2;
        bv a11 = bv.a(jSONObject, auVar);
        cf a12 = cf.a(jSONObject, auVar);
        JSONArray optJSONArray = jSONObject.optJSONArray("selector");
        if (optJSONArray != null) {
            return new cn(str, str2, a11, a12, db.a(optJSONArray));
        }
        throw new ca("No selector in visual metric");
    }

    public List<az> b() {
        return this.f41702c.a();
    }

    public List<az> c() {
        return this.f41703d.a();
    }

    public dc d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new de(this.f41701b, this.f41700a));
        return new dc(arrayList, this.f41704e);
    }

    public List<cs> e() {
        return Collections.emptyList();
    }

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        this.f41702c.a(jSONObject);
        this.f41703d.a(jSONObject);
        jSONObject.put("metricName", (Object) this.f41700a);
        jSONObject.put(AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE, (Object) this.f41701b);
        List<db> list = this.f41704e;
        if (list != null) {
            jSONObject.put("selector", (Object) db.a(list));
        }
        return jSONObject;
    }

    public boolean a(co coVar) {
        return coVar.a(this);
    }
}

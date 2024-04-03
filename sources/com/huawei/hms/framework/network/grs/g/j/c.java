package com.huawei.hms.framework.network.grs.g.j;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.f.b;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final GrsBaseInfo f48934a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f48935b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<String> f48936c = new HashSet();

    public c(GrsBaseInfo grsBaseInfo, Context context) {
        this.f48934a = grsBaseInfo;
        this.f48935b = context;
    }

    private String e() {
        Set<String> b11 = b.a(this.f48935b.getPackageName()).b();
        if (b11.isEmpty()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (String put : b11) {
            jSONArray.put((Object) put);
        }
        try {
            jSONObject.put("services", (Object) jSONArray);
            Logger.i("GrsRequestInfo", "post service list is:%s", JSONObjectInstrumentation.toString(jSONObject));
            return JSONObjectInstrumentation.toString(jSONObject);
        } catch (JSONException unused) {
            return "";
        }
    }

    private String f() {
        Logger.v("GrsRequestInfo", "getGeoipService enter");
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (String put : this.f48936c) {
            jSONArray.put((Object) put);
        }
        try {
            jSONObject.put("services", (Object) jSONArray);
            Logger.v("GrsRequestInfo", "post query service list is:%s", JSONObjectInstrumentation.toString(jSONObject));
            return JSONObjectInstrumentation.toString(jSONObject);
        } catch (JSONException unused) {
            return "";
        }
    }

    public Context a() {
        return this.f48935b;
    }

    public void a(String str) {
        this.f48936c.add(str);
    }

    public GrsBaseInfo b() {
        return this.f48934a;
    }

    public String c() {
        return this.f48936c.size() == 0 ? e() : f();
    }

    public Set<String> d() {
        return this.f48936c;
    }
}

package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.braze.models.FeatureFlag;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class h1 implements o1 {

    /* renamed from: a  reason: collision with root package name */
    private List<b1> f49026a;

    /* renamed from: b  reason: collision with root package name */
    private k0 f49027b;

    /* renamed from: c  reason: collision with root package name */
    private t0 f49028c;

    /* renamed from: d  reason: collision with root package name */
    private o1 f49029d;

    /* renamed from: e  reason: collision with root package name */
    private String f49030e = "";

    /* renamed from: f  reason: collision with root package name */
    private String f49031f;

    public h1(String str) {
        this.f49031f = str;
    }

    public JSONObject a() {
        String str;
        List<b1> list = this.f49026a;
        if (list == null || list.size() == 0) {
            str = "Not have actionEvent to send";
        } else if (this.f49027b == null || this.f49028c == null || this.f49029d == null) {
            str = "model in wrong format";
        } else {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("header", (Object) this.f49027b.a());
            JSONObject jSONObject2 = new JSONObject();
            JSONObject a11 = this.f49029d.a();
            a11.put(FeatureFlag.PROPERTIES, (Object) this.f49028c.a());
            try {
                a11.put("events_global_properties", (Object) new JSONObject(this.f49030e));
            } catch (JSONException unused) {
                a11.put("events_global_properties", (Object) this.f49030e);
            }
            jSONObject2.put("events_common", (Object) a11);
            JSONArray jSONArray = new JSONArray();
            for (b1 a12 : this.f49026a) {
                JSONObject a13 = a12.a();
                if (a13 != null) {
                    jSONArray.put((Object) a13);
                } else {
                    v.e("hmsSdk", "custom event is empty,delete this event");
                }
            }
            jSONObject2.put("events", (Object) jSONArray);
            try {
                String a14 = n.a(k1.a(JSONObjectInstrumentation.toString(jSONObject2).getBytes("UTF-8")), this.f49031f);
                if (TextUtils.isEmpty(a14)) {
                    v.e("hmsSdk", "eventInfo encrypt failed,report over!");
                    return null;
                }
                jSONObject.put("event", (Object) a14);
                return jSONObject;
            } catch (UnsupportedEncodingException unused2) {
                str = "getBitZip(): Unsupported coding : utf-8";
            }
        }
        v.e("hmsSdk", str);
        return null;
    }

    public void a(k0 k0Var) {
        this.f49027b = k0Var;
    }

    public void a(l lVar) {
        this.f49029d = lVar;
    }

    public void a(t0 t0Var) {
        this.f49028c = t0Var;
    }

    public void a(String str) {
        if (str != null) {
            this.f49030e = str;
        }
    }

    public void a(List<b1> list) {
        this.f49026a = list;
    }
}

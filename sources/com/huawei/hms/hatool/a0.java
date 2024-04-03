package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class a0 implements g {

    /* renamed from: a  reason: collision with root package name */
    private Context f48958a = q0.i();

    /* renamed from: b  reason: collision with root package name */
    private String f48959b;

    /* renamed from: c  reason: collision with root package name */
    private JSONObject f48960c;

    /* renamed from: d  reason: collision with root package name */
    private String f48961d;

    /* renamed from: e  reason: collision with root package name */
    private String f48962e;

    /* renamed from: f  reason: collision with root package name */
    private String f48963f;

    /* renamed from: g  reason: collision with root package name */
    private String f48964g;

    /* renamed from: h  reason: collision with root package name */
    private Boolean f48965h;

    public a0(String str, JSONObject jSONObject, String str2, String str3, long j11) {
        this.f48959b = str;
        this.f48960c = jSONObject;
        this.f48961d = str2;
        this.f48962e = str3;
        this.f48963f = String.valueOf(j11);
        if (z.i(str2, "oper")) {
            p0 a11 = y.a().a(str2, j11);
            this.f48964g = a11.a();
            this.f48965h = Boolean.valueOf(a11.b());
        }
    }

    public void run() {
        JSONArray jSONArray;
        v.c("hmsSdk", "Begin to run EventRecordTask...");
        int h11 = q0.h();
        int k11 = a1.k(this.f48961d, this.f48962e);
        if (c0.a(this.f48958a, "stat_v2_1", h11 * 1048576)) {
            v.c("hmsSdk", "stat sp file reach max limited size, discard new event");
            e.a().a("", "alltype");
            return;
        }
        b1 b1Var = new b1();
        b1Var.b(this.f48959b);
        JSONObject jSONObject = this.f48960c;
        b1Var.a(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
        b1Var.d(this.f48962e);
        b1Var.c(this.f48963f);
        b1Var.f(this.f48964g);
        Boolean bool = this.f48965h;
        b1Var.e(bool == null ? null : String.valueOf(bool));
        try {
            JSONObject d11 = b1Var.d();
            String a11 = n1.a(this.f48961d, this.f48962e);
            String a12 = d.a(this.f48958a, "stat_v2_1", a11, "");
            try {
                jSONArray = !TextUtils.isEmpty(a12) ? new JSONArray(a12) : new JSONArray();
            } catch (JSONException unused) {
                v.d("hmsSdk", "Cached data corrupted: stat_v2_1");
                jSONArray = new JSONArray();
            }
            jSONArray.put((Object) d11);
            d.b(this.f48958a, "stat_v2_1", a11, JSONArrayInstrumentation.toString(jSONArray));
            if (JSONArrayInstrumentation.toString(jSONArray).length() > k11 * 1024) {
                e.a().a(this.f48961d, this.f48962e);
            }
        } catch (JSONException unused2) {
            v.e("hmsSdk", "eventRecord toJson error! The record failed.");
        }
    }
}

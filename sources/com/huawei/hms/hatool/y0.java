package com.huawei.hms.hatool;

import android.os.Build;
import org.json.JSONObject;

public class y0 extends t0 {

    /* renamed from: f  reason: collision with root package name */
    String f49147f;

    /* renamed from: g  reason: collision with root package name */
    String f49148g;

    /* renamed from: h  reason: collision with root package name */
    private String f49149h;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("_rom_ver", (Object) this.f49149h);
        jSONObject.put("_emui_ver", (Object) this.f49130a);
        jSONObject.put("_model", (Object) Build.MODEL);
        jSONObject.put("_mcc", (Object) this.f49147f);
        jSONObject.put("_mnc", (Object) this.f49148g);
        jSONObject.put("_package_name", (Object) this.f49131b);
        jSONObject.put("_app_ver", (Object) this.f49132c);
        jSONObject.put("_lib_ver", (Object) "2.2.0.314");
        jSONObject.put("_channel", (Object) this.f49133d);
        jSONObject.put("_lib_name", (Object) "hianalytics");
        jSONObject.put("_oaid_tracking_flag", (Object) this.f49134e);
        return jSONObject;
    }

    public void f(String str) {
        this.f49147f = str;
    }

    public void g(String str) {
        this.f49148g = str;
    }

    public void h(String str) {
        this.f49149h = str;
    }
}

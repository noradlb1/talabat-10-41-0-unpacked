package com.huawei.hms.hatool;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import org.json.JSONObject;

public class f0 extends k0 {

    /* renamed from: g  reason: collision with root package name */
    private String f49003g = "";

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("protocol_version", (Object) ExifInterface.GPS_MEASUREMENT_3D);
        jSONObject.put("compress_mode", (Object) "1");
        jSONObject.put("serviceid", (Object) this.f49057d);
        jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_APPID, (Object) this.f49054a);
        jSONObject.put("hmac", (Object) this.f49003g);
        jSONObject.put("chifer", (Object) this.f49059f);
        jSONObject.put("timestamp", (Object) this.f49055b);
        jSONObject.put("servicetag", (Object) this.f49056c);
        jSONObject.put("requestid", (Object) this.f49058e);
        return jSONObject;
    }

    public void g(String str) {
        this.f49003g = str;
    }
}

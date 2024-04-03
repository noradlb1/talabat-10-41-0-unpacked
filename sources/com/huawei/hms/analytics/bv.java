package com.huawei.hms.analytics;

import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.framework.config.DeviceAttributeCollector;
import org.json.JSONException;
import org.json.JSONObject;

public final class bv implements DeviceAttributeCollector {
    String fgh;
    String ghi;
    String hij = "";
    String ijk = "";
    String ikl = "";
    String klm = "";
    String lmn = "";

    public final JSONObject doCollector() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("aaid", (Object) this.lmn);
            jSONObject.put("oaid", (Object) this.klm);
            jSONObject.put("oaid_source", (Object) this.hij);
            jSONObject.put("userid", (Object) this.ikl);
            jSONObject.put("wxunionid", (Object) this.ghi);
            jSONObject.put("wxopenid", (Object) this.fgh);
            jSONObject.put("events_global_properties", (Object) this.ijk);
        } catch (JSONException unused) {
            HiLog.w("OpennessDeviceGathering", "doCollector JSONException");
        }
        return jSONObject;
    }
}

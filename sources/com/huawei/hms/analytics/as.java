package com.huawei.hms.analytics;

import org.json.JSONException;
import org.json.JSONObject;

public final class as {
    private String ghi;
    private String hij;
    private String ijk;
    private String ikl;
    String klm;
    String lmn;

    public as(String str) {
        JSONObject jSONObject = new JSONObject(str);
        this.ikl = jSONObject.optString("activityId");
        this.ijk = jSONObject.optString("nodeId");
        this.hij = jSONObject.optString("source");
        this.ghi = jSONObject.optString("medium");
        this.lmn = jSONObject.optString("endTime", "0");
        this.klm = str;
    }

    public final JSONObject lmn() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("aid", this.ikl);
            jSONObject.putOpt("nid", this.ijk);
            jSONObject.putOpt("s", this.hij);
            jSONObject.putOpt("m", this.ghi);
            jSONObject.putOpt("t", this.lmn);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}

package com.huawei.hms.activity.internal;

import com.facebook.internal.NativeProtocol;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class ForegroundInnerHeader {

    /* renamed from: a  reason: collision with root package name */
    private int f47757a;

    /* renamed from: b  reason: collision with root package name */
    private String f47758b;

    /* renamed from: c  reason: collision with root package name */
    private String f47759c;

    public void fromJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f47757a = JsonUtil.getIntValue(jSONObject, "apkVersion");
            this.f47758b = JsonUtil.getStringValue(jSONObject, NativeProtocol.WEB_DIALOG_ACTION);
            this.f47759c = JsonUtil.getStringValue(jSONObject, "responseCallbackKey");
        } catch (JSONException e11) {
            HMSLog.e("ForegroundInnerHeader", "fromJson failed: " + e11.getMessage());
        }
    }

    public String getAction() {
        return this.f47758b;
    }

    public int getApkVersion() {
        return this.f47757a;
    }

    public String getResponseCallbackKey() {
        return this.f47759c;
    }

    public void setAction(String str) {
        this.f47758b = str;
    }

    public void setApkVersion(int i11) {
        this.f47757a = i11;
    }

    public void setResponseCallbackKey(String str) {
        this.f47759c = str;
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("apkVersion", this.f47757a);
            jSONObject.put(NativeProtocol.WEB_DIALOG_ACTION, (Object) this.f47758b);
            jSONObject.put("responseCallbackKey", (Object) this.f47759c);
        } catch (JSONException e11) {
            HMSLog.e("ForegroundInnerHeader", "ForegroundInnerHeader toJson failed: " + e11.getMessage());
        }
        return JSONObjectInstrumentation.toString(jSONObject);
    }

    public String toString() {
        return "apkVersion:" + this.f47757a + ", action:" + this.f47758b + ", responseCallbackKey:" + this.f47759c;
    }
}

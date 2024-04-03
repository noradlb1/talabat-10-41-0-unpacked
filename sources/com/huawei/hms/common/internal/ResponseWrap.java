package com.huawei.hms.common.internal;

import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class ResponseWrap {

    /* renamed from: a  reason: collision with root package name */
    private String f48189a;

    /* renamed from: b  reason: collision with root package name */
    private ResponseHeader f48190b;

    public ResponseWrap(ResponseHeader responseHeader) {
        this.f48190b = responseHeader;
    }

    public boolean fromJson(String str) {
        if (this.f48190b == null) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f48190b.setStatusCode(JsonUtil.getIntValue(jSONObject, "status_code"));
            this.f48190b.setErrorCode(JsonUtil.getIntValue(jSONObject, "error_code"));
            this.f48190b.setErrorReason(JsonUtil.getStringValue(jSONObject, "error_reason"));
            this.f48190b.setSrvName(JsonUtil.getStringValue(jSONObject, "srv_name"));
            this.f48190b.setApiName(JsonUtil.getStringValue(jSONObject, "api_name"));
            this.f48190b.setAppID(JsonUtil.getStringValue(jSONObject, "app_id"));
            this.f48190b.setPkgName(JsonUtil.getStringValue(jSONObject, "pkg_name"));
            this.f48190b.setSessionId(JsonUtil.getStringValue(jSONObject, "session_id"));
            this.f48190b.setTransactionId(JsonUtil.getStringValue(jSONObject, "transaction_id"));
            this.f48190b.setResolution(JsonUtil.getStringValue(jSONObject, "resolution"));
            this.f48189a = JsonUtil.getStringValue(jSONObject, "body");
            return true;
        } catch (JSONException e11) {
            HMSLog.e("ResponseWrap", "fromJson failed: " + e11.getMessage());
            return false;
        }
    }

    public String getBody() {
        if (TextUtils.isEmpty(this.f48189a)) {
            this.f48189a = JSONObjectInstrumentation.toString(new JSONObject());
        }
        return this.f48189a;
    }

    public ResponseHeader getResponseHeader() {
        return this.f48190b;
    }

    public void setBody(String str) {
        this.f48189a = str;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.f48190b = responseHeader;
    }

    public String toJson() {
        if (this.f48190b == null) {
            return "{}";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status_code", this.f48190b.getStatusCode());
            jSONObject.put("error_code", this.f48190b.getErrorCode());
            jSONObject.put("error_reason", (Object) this.f48190b.getErrorReason());
            jSONObject.put("srv_name", (Object) this.f48190b.getSrvName());
            jSONObject.put("api_name", (Object) this.f48190b.getApiName());
            jSONObject.put("app_id", (Object) this.f48190b.getAppID());
            jSONObject.put("pkg_name", (Object) this.f48190b.getPkgName());
            jSONObject.put("transaction_id", (Object) this.f48190b.getTransactionId());
            jSONObject.put("resolution", (Object) this.f48190b.getResolution());
            String sessionId = this.f48190b.getSessionId();
            if (!TextUtils.isEmpty(sessionId)) {
                jSONObject.put("session_id", (Object) sessionId);
            }
            if (!TextUtils.isEmpty(this.f48189a)) {
                jSONObject.put("body", (Object) this.f48189a);
            }
        } catch (JSONException e11) {
            HMSLog.e("ResponseWrap", "toJson failed: " + e11.getMessage());
        }
        return JSONObjectInstrumentation.toString(jSONObject);
    }

    public String toString() {
        return "ResponseWrap{body='" + this.f48189a + '\'' + ", responseHeader=" + this.f48190b + AbstractJsonLexerKt.END_OBJ;
    }
}

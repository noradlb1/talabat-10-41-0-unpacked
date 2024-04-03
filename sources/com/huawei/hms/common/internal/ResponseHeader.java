package com.huawei.hms.common.internal;

import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class ResponseHeader implements IMessageEntity, ResponseErrorCode {
    private static final String TAG = "ResponseHeader";
    @Packed
    private String api_name;
    @Packed
    private String app_id = "";
    @Packed
    private int error_code;
    @Packed
    private String error_reason;
    private Parcelable parcelable;
    @Packed
    private String pkg_name;
    @Packed
    private String resolution;
    @Packed
    private String session_id;
    @Packed
    private String srv_name;
    @Packed
    private int status_code;
    @Packed
    private String transaction_id;

    public ResponseHeader() {
    }

    public boolean fromJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.status_code = JsonUtil.getIntValue(jSONObject, "status_code");
            this.error_code = JsonUtil.getIntValue(jSONObject, "error_code");
            this.error_reason = JsonUtil.getStringValue(jSONObject, "error_reason");
            this.srv_name = JsonUtil.getStringValue(jSONObject, "srv_name");
            this.api_name = JsonUtil.getStringValue(jSONObject, "api_name");
            this.app_id = JsonUtil.getStringValue(jSONObject, "app_id");
            this.pkg_name = JsonUtil.getStringValue(jSONObject, "pkg_name");
            this.session_id = JsonUtil.getStringValue(jSONObject, "session_id");
            this.transaction_id = JsonUtil.getStringValue(jSONObject, "transaction_id");
            this.resolution = JsonUtil.getStringValue(jSONObject, "resolution");
            return true;
        } catch (JSONException e11) {
            HMSLog.e(TAG, "fromJson failed: " + e11.getMessage());
            return false;
        }
    }

    public String getActualAppID() {
        if (TextUtils.isEmpty(this.app_id)) {
            return "";
        }
        String[] split = this.app_id.split("\\|");
        if (split.length == 0) {
            return "";
        }
        if (split.length == 1) {
            return split[0];
        }
        return split[1];
    }

    public String getApiName() {
        return this.api_name;
    }

    public String getAppID() {
        return this.app_id;
    }

    public int getErrorCode() {
        return this.error_code;
    }

    public String getErrorReason() {
        return this.error_reason;
    }

    public Parcelable getParcelable() {
        return this.parcelable;
    }

    public String getPkgName() {
        return this.pkg_name;
    }

    public String getResolution() {
        return this.resolution;
    }

    public String getSessionId() {
        return this.session_id;
    }

    public String getSrvName() {
        return this.srv_name;
    }

    public int getStatusCode() {
        return this.status_code;
    }

    public String getTransactionId() {
        return this.transaction_id;
    }

    public boolean hasResolution() {
        return this.parcelable != null;
    }

    public boolean isSuccess() {
        return this.status_code == 0;
    }

    public void setApiName(String str) {
        this.api_name = str;
    }

    public void setAppID(String str) {
        this.app_id = str;
    }

    public void setErrorCode(int i11) {
        this.error_code = i11;
    }

    public void setErrorReason(String str) {
        this.error_reason = str;
    }

    public void setParcelable(Parcelable parcelable2) {
        this.parcelable = parcelable2;
    }

    public void setPkgName(String str) {
        this.pkg_name = str;
    }

    public void setResolution(String str) {
        this.resolution = str;
    }

    public void setSessionId(String str) {
        this.session_id = str;
    }

    public void setSrvName(String str) {
        this.srv_name = str;
    }

    public void setStatusCode(int i11) {
        this.status_code = i11;
    }

    public void setTransactionId(String str) {
        this.transaction_id = str;
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status_code", this.status_code);
            jSONObject.put("error_code", this.error_code);
            jSONObject.put("error_reason", (Object) this.error_reason);
            jSONObject.put("srv_name", (Object) this.srv_name);
            jSONObject.put("api_name", (Object) this.api_name);
            jSONObject.put("app_id", (Object) this.app_id);
            jSONObject.put("pkg_name", (Object) this.pkg_name);
            if (!TextUtils.isEmpty(this.session_id)) {
                jSONObject.put("session_id", (Object) this.session_id);
            }
            jSONObject.put("transaction_id", (Object) this.transaction_id);
            jSONObject.put("resolution", (Object) this.resolution);
        } catch (JSONException e11) {
            HMSLog.e(TAG, "toJson failed: " + e11.getMessage());
        }
        return JSONObjectInstrumentation.toString(jSONObject);
    }

    public String toString() {
        return "status_code:" + this.status_code + ", error_code:" + this.error_code + ", api_name:" + this.api_name + ", app_id:" + this.app_id + ", pkg_name:" + this.pkg_name + ", session_id:*, transaction_id:" + this.transaction_id + ", resolution:" + this.resolution;
    }

    public ResponseHeader(int i11, int i12, String str) {
        this.status_code = i11;
        this.error_code = i12;
        this.error_reason = str;
    }
}

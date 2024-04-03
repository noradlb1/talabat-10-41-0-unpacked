package com.huawei.location.lite.common.agc.net;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.huawei.location.lite.common.http.response.BaseResponse;

public class AGCResponse extends BaseResponse {
    @SerializedName("expireTime")
    private long expireTime;
    @SerializedName("token")
    private String token;

    public String getApiCode() {
        return String.valueOf(this.code);
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public String getToken() {
        return this.token;
    }

    public boolean isSuccess() {
        return TextUtils.equals(this.code, "0");
    }

    public void setExpireTime(long j11) {
        this.expireTime = j11;
    }

    public void setToken(String str) {
        this.token = str;
    }
}

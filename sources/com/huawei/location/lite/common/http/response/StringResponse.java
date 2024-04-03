package com.huawei.location.lite.common.http.response;

import android.text.TextUtils;

public class StringResponse extends BaseResponse {
    private String body;

    public String getApiCode() {
        return this.code;
    }

    public String getBody() {
        return this.body;
    }

    public boolean isSuccess() {
        return TextUtils.equals(this.code, "0");
    }
}

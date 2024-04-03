package com.huawei.location.lite.common.config;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.huawei.location.lite.common.http.response.BaseResponse;
import java.util.ArrayList;

public class ConfigResponseData extends BaseResponse {
    @SerializedName("data")
    private ArrayList<ConfigResponseItem> data;

    public String getApiCode() {
        return String.valueOf(this.code);
    }

    public ArrayList<ConfigResponseItem> getData() {
        return this.data;
    }

    public boolean isSuccess() {
        return TextUtils.equals(this.code, "0") || TextUtils.isEmpty(this.code);
    }
}

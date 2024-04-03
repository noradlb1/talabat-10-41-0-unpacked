package com.huawei.location.lite.common.agc;

import com.google.gson.annotations.SerializedName;

public class yn {
    @SerializedName("token")
    private String Vw;
    @SerializedName("expireTime")

    /* renamed from: yn  reason: collision with root package name */
    private long f50101yn;

    public String Vw() {
        return this.Vw;
    }

    public long yn() {
        return this.f50101yn;
    }

    public void yn(long j11) {
        this.f50101yn = j11;
    }

    public void yn(String str) {
        this.Vw = str;
    }
}

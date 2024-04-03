package com.huawei.agconnect.credential.obs;

import com.huawei.agconnect.https.annotation.Result;

public class y {
    @Result("access_token")
    private String access_token;
    @Result("expires_in")
    private long expires_in;
    @Result("ret")
    private z ret;

    public String getAccessToken() {
        return this.access_token;
    }

    public long getExpiresIn() {
        return this.expires_in;
    }

    public z getRet() {
        return this.ret;
    }
}

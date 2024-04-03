package com.huawei.agconnect.credential.obs;

import com.huawei.agconnect.https.annotation.Result;

public class ad {
    @Result("domain")
    String domain;
    @Result("siteCode")
    String siteCode;

    public String a() {
        return this.siteCode;
    }

    public String b() {
        return this.domain;
    }
}

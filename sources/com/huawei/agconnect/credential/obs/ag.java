package com.huawei.agconnect.credential.obs;

import com.huawei.agconnect.https.annotation.Result;
import java.util.List;

public class ag {
    @Result("backDomain")
    private List<ad> backDomain;
    @Result("mainDomain")
    private List<ad> mainDomain;
    @Result("ret")
    private z ret;
    @Result("ttl")
    String ttl;

    public List<ad> a() {
        return this.mainDomain;
    }

    public List<ad> b() {
        return this.backDomain;
    }

    public String c() {
        return this.ttl;
    }
}

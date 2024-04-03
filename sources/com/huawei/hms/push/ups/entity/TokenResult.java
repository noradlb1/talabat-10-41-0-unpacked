package com.huawei.hms.push.ups.entity;

public class TokenResult extends CodeResult {

    /* renamed from: c  reason: collision with root package name */
    private String f49797c;

    public TokenResult() {
    }

    public String getToken() {
        return this.f49797c;
    }

    public void setToken(String str) {
        this.f49797c = str;
    }

    public TokenResult(int i11) {
        super(i11);
    }

    public TokenResult(int i11, String str) {
        super(i11, str);
    }

    public TokenResult(String str) {
        this.f49797c = str;
    }
}

package com.huawei.hms.push.ups.entity;

public class CodeResult {

    /* renamed from: a  reason: collision with root package name */
    private int f49795a;

    /* renamed from: b  reason: collision with root package name */
    private String f49796b;

    public CodeResult() {
    }

    public String getReason() {
        return this.f49796b;
    }

    public int getReturnCode() {
        return this.f49795a;
    }

    public void setReason(String str) {
        this.f49796b = str;
    }

    public void setReturnCode(int i11) {
        this.f49795a = i11;
    }

    public CodeResult(int i11) {
        this.f49795a = i11;
    }

    public CodeResult(int i11, String str) {
        this.f49795a = i11;
        this.f49796b = str;
    }
}

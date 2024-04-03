package com.huawei.hms.dtm.core;

public class V extends RuntimeException {

    /* renamed from: a  reason: collision with root package name */
    private String f48425a;

    public V(String str) {
        super(str);
        this.f48425a = str;
    }

    public String getMessage() {
        return this.f48425a;
    }

    public String toString() {
        return this.f48425a;
    }
}

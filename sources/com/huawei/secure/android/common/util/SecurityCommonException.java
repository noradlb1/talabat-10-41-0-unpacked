package com.huawei.secure.android.common.util;

public class SecurityCommonException extends Exception {

    /* renamed from: c  reason: collision with root package name */
    private static final long f34004c = 1;

    /* renamed from: a  reason: collision with root package name */
    private String f34005a;

    /* renamed from: b  reason: collision with root package name */
    private String f34006b;

    public SecurityCommonException() {
    }

    public String getMsgDes() {
        return this.f34006b;
    }

    public String getRetCd() {
        return this.f34005a;
    }

    public SecurityCommonException(Throwable th2) {
        super(th2);
    }

    public SecurityCommonException(String str, Throwable th2) {
        super(str, th2);
    }

    public SecurityCommonException(String str) {
        super(str);
        this.f34006b = str;
    }

    public SecurityCommonException(String str, String str2) {
        this.f34005a = str;
        this.f34006b = str2;
    }
}

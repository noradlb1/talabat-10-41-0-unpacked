package com.huawei.agconnect.common.api;

import com.huawei.agconnect.credential.obs.j;

public class Logger {
    private static final j SINGLETON = new j();

    public static void d(String str, String str2) {
        SINGLETON.b(str, str2);
    }

    public static void e(String str, String str2) {
        SINGLETON.a(str, str2, (Throwable) null);
    }

    public static void e(String str, String str2, Throwable th2) {
        SINGLETON.a(str, str2, th2);
    }

    public static void i(String str, String str2) {
        SINGLETON.c(str, str2);
    }

    public static void v(String str, String str2) {
        SINGLETON.a(str, str2);
    }

    public static void w(String str, String str2) {
        SINGLETON.d(str, str2);
    }
}

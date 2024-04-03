package com.huawei.secure.android.common.ssl.util;

import android.util.Log;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33965a = "SecurityComp10200303: ";

    public static void a(String str, String str2) {
    }

    public static void a(String str, String str2, Throwable th2) {
        Log.e(a(str), str2, th2);
    }

    public static void b(String str, String str2) {
        Log.e(a(str), str2);
    }

    public static void c(String str, String str2) {
        Log.i(a(str), str2);
    }

    public static void d(String str, String str2) {
        a(str);
    }

    public static void e(String str, String str2) {
        Log.w(a(str), str2);
    }

    private static String a(String str) {
        return f33965a + str;
    }
}

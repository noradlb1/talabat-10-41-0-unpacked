package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33967a = "aegis";

    /* renamed from: b  reason: collision with root package name */
    private static SharedPreferences f33968b;

    public static long a(String str, long j11, Context context) {
        return b(context).getLong(str, j11);
    }

    public static synchronized SharedPreferences b(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (g.class) {
            if (f33968b == null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    f33968b = context.createDeviceProtectedStorageContext().getSharedPreferences(f33967a, 0);
                } else {
                    f33968b = context.getApplicationContext().getSharedPreferences(f33967a, 0);
                }
            }
            sharedPreferences = f33968b;
        }
        return sharedPreferences;
    }

    public static int a(String str, int i11, Context context) {
        return b(context).getInt(str, i11);
    }

    public static String a(String str, String str2, Context context) {
        return b(context).getString(str, str2);
    }

    public static void a(String str, Context context) {
        b(context).edit().remove(str).apply();
    }

    public static void a(Context context) {
        b(context).edit().clear().apply();
    }

    public static void b(String str, long j11, Context context) {
        b(context).edit().putLong(str, j11).apply();
    }

    public static void b(String str, int i11, Context context) {
        b(context).edit().putInt(str, i11).apply();
    }

    public static void b(String str, String str2, Context context) {
        b(context).edit().putString(str, str2).apply();
    }
}

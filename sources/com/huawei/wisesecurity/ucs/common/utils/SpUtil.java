package com.huawei.wisesecurity.ucs.common.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;

public class SpUtil {
    public static final String FILE_NAME = "ucs.sdk";
    public static SharedPreferences mSharedPreferences;

    public static void clear(Context context) {
        getInstance(context).edit().clear().apply();
    }

    public static synchronized SharedPreferences getInstance(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (SpUtil.class) {
            if (mSharedPreferences == null) {
                mSharedPreferences = Build.VERSION.SDK_INT >= 24 ? context.createDeviceProtectedStorageContext().getSharedPreferences(FILE_NAME, 0) : context.getApplicationContext().getSharedPreferences(FILE_NAME, 0);
            }
            sharedPreferences = mSharedPreferences;
        }
        return sharedPreferences;
    }

    public static int getInt(String str, int i11, Context context) {
        return getInstance(context).getInt(str, i11);
    }

    public static long getLong(String str, long j11, Context context) {
        return getInstance(context).getLong(str, j11);
    }

    public static String getString(String str, String str2, Context context) {
        return getInstance(context).getString(str, str2);
    }

    public static boolean isEmpty(String str, Context context) {
        return TextUtils.isEmpty(getString(str, "", context));
    }

    public static void putInt(String str, int i11, Context context) {
        getInstance(context).edit().putInt(str, i11).apply();
    }

    public static void putLong(String str, long j11, Context context) {
        getInstance(context).edit().putLong(str, j11).apply();
    }

    public static void putString(String str, String str2, Context context) {
        getInstance(context).edit().putString(str, str2).apply();
    }

    public static void remove(String str, Context context) {
        getInstance(context).edit().remove(str).apply();
    }

    public static void removeStartKeys(String str, Context context) {
        SharedPreferences instance = getInstance(context);
        SharedPreferences.Editor edit = instance.edit();
        for (String next : instance.getAll().keySet()) {
            if (next.startsWith(str)) {
                edit.remove(next);
            }
        }
        edit.apply();
    }
}

package com.huawei.secure.android.common.activity;

import android.text.TextUtils;
import android.util.Log;
import java.util.regex.Pattern;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f33679a = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");

    /* renamed from: b  reason: collision with root package name */
    private static final char f33680b = '*';

    /* renamed from: c  reason: collision with root package name */
    private static final String f33681c = "SecurityComp10200300: ";

    /* renamed from: d  reason: collision with root package name */
    private static final int f33682d = 2;

    public static void a(String str, String str2, boolean z11) {
        if (!TextUtils.isEmpty(str2)) {
            Log.e(b(str), a(str2, z11));
        }
    }

    private static String b(String str) {
        return f33681c + str;
    }

    public static void b(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            Log.i(b(str), a(str2, false));
        }
    }

    public static void a(String str, String str2, Throwable th2) {
        if (!TextUtils.isEmpty(str2)) {
            String b11 = b(str);
            Log.e(b11, str2 + " , throwable message : " + th2.getMessage());
        }
    }

    public static void b(String str, String str2, boolean z11) {
        if (!TextUtils.isEmpty(str2)) {
            Log.i(b(str), a(str2, z11));
        }
    }

    public static void a(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            Log.e(b(str), a(str2, false));
        }
    }

    private static String a(String str, boolean z11) {
        StringBuilder sb2 = new StringBuilder(512);
        if (!TextUtils.isEmpty(str)) {
            if (z11) {
                sb2.append(a(str));
            } else {
                sb2.append(str);
            }
        }
        return sb2.toString();
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        int i11 = 1;
        if (1 == length) {
            return String.valueOf('*');
        }
        StringBuilder sb2 = new StringBuilder(length);
        for (int i12 = 0; i12 < length; i12++) {
            char charAt = str.charAt(i12);
            if (f33679a.matcher(String.valueOf(charAt)).matches()) {
                if (i11 % 2 == 0) {
                    charAt = '*';
                }
                i11++;
            }
            sb2.append(charAt);
        }
        return sb2.toString();
    }
}

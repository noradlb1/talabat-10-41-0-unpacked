package com.huawei.secure.android.common.util;

import android.util.Log;

public class SafeStringBuffer {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33997a = "SafeStringBuffer";

    /* renamed from: b  reason: collision with root package name */
    private static final String f33998b = "";

    public static String substring(StringBuffer stringBuffer, int i11) {
        if (stringBuffer != null && stringBuffer.length() >= i11 && i11 >= 0) {
            try {
                return stringBuffer.substring(i11);
            } catch (Exception e11) {
                String str = f33997a;
                Log.e(str, "substring exception: " + e11.getMessage());
            }
        }
        return "";
    }

    public static String substring(StringBuffer stringBuffer, int i11, int i12) {
        if (stringBuffer != null && i11 >= 0 && i12 <= stringBuffer.length() && i12 >= i11) {
            try {
                return stringBuffer.substring(i11, i12);
            } catch (Exception e11) {
                String str = f33997a;
                Log.e(str, "substring: " + e11.getMessage());
            }
        }
        return "";
    }
}

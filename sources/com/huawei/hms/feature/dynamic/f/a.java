package com.huawei.hms.feature.dynamic.f;

import android.util.Base64;
import com.huawei.hms.common.util.Logger;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f48797a = "Base64";

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            String encodeToString = Base64.encodeToString(bArr, 2);
            return encodeToString != null ? encodeToString : "";
        } catch (AssertionError e11) {
            Logger.e(f48797a, "An exception occurred while encoding with Base64,AssertionError:", (Throwable) e11);
        }
    }

    public static byte[] a(String str) {
        if (str == null) {
            return new byte[0];
        }
        try {
            byte[] decode = Base64.decode(str, 2);
            if (decode != null) {
                return decode;
            }
        } catch (IllegalArgumentException e11) {
            Logger.e(f48797a, "Decoding with Base64 IllegalArgumentException:", (Throwable) e11);
        }
        return new byte[0];
    }
}

package com.huawei.hms.push;

import com.checkout.frames.utils.constants.ExpiryDateConstantsKt;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f49738a = {'0', ExpiryDateConstantsKt.EXPIRY_DATE_ZERO_POSITION_CHECK, '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        return new String(bArr, k.f49748a);
    }
}

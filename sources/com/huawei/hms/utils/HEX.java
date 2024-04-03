package com.huawei.hms.utils;

import com.checkout.frames.utils.constants.ExpiryDateConstantsKt;
import com.google.common.base.Ascii;
import net.bytebuddy.asm.Advice;

public final class HEX {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f49923a = {'0', ExpiryDateConstantsKt.EXPIRY_DATE_ZERO_POSITION_CHECK, '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL, 'e', 'f'};

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f49924b = {'0', ExpiryDateConstantsKt.EXPIRY_DATE_ZERO_POSITION_CHECK, '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private HEX() {
    }

    private static char[] a(byte[] bArr, char[] cArr) {
        if (bArr == null) {
            return new char[0];
        }
        char[] cArr2 = new char[(r1 << 1)];
        int i11 = 0;
        for (byte b11 : bArr) {
            int i12 = i11 + 1;
            cArr2[i11] = cArr[(b11 & 240) >>> 4];
            i11 = i12 + 1;
            cArr2[i12] = cArr[b11 & Ascii.SI];
        }
        return cArr2;
    }

    public static char[] encodeHex(byte[] bArr) {
        return encodeHex(bArr, false);
    }

    public static String encodeHexString(byte[] bArr, boolean z11) {
        return new String(encodeHex(bArr, z11));
    }

    public static char[] encodeHex(byte[] bArr, boolean z11) {
        return a(bArr, z11 ? f49924b : f49923a);
    }
}

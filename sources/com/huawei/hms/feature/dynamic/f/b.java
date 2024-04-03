package com.huawei.hms.feature.dynamic.f;

import com.checkout.frames.utils.constants.ExpiryDateConstantsKt;
import com.google.common.base.Ascii;
import net.bytebuddy.asm.Advice;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f48798a = {'0', ExpiryDateConstantsKt.EXPIRY_DATE_ZERO_POSITION_CHECK, '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL, 'e', 'f'};

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f48799b = {'0', ExpiryDateConstantsKt.EXPIRY_DATE_ZERO_POSITION_CHECK, '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static char[] a(byte[] bArr) {
        return a(bArr, false);
    }

    public static char[] a(byte[] bArr, boolean z11) {
        return a(bArr, z11 ? f48799b : f48798a);
    }

    private static char[] a(byte[] bArr, char[] cArr) {
        char[] cArr2 = new char[(r0 << 1)];
        int i11 = 0;
        for (byte b11 : bArr) {
            int i12 = i11 + 1;
            cArr2[i11] = cArr[(b11 & 240) >>> 4];
            i11 = i12 + 1;
            cArr2[i12] = cArr[b11 & Ascii.SI];
        }
        return cArr2;
    }

    public static String b(byte[] bArr, boolean z11) {
        return new String(a(bArr, z11));
    }
}

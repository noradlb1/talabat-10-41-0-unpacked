package com.huawei.wisesecurity.kfs.util;

import com.checkout.frames.utils.constants.ExpiryDateConstantsKt;
import com.google.common.base.Ascii;
import com.huawei.wisesecurity.kfs.exception.CodecException;
import net.bytebuddy.asm.Advice;

public final class HexUtil {
    public static final char[] DIGITS_LOWER = {'0', ExpiryDateConstantsKt.EXPIRY_DATE_ZERO_POSITION_CHECK, '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL, 'e', 'f'};
    public static final char[] DIGITS_UPPER = {'0', ExpiryDateConstantsKt.EXPIRY_DATE_ZERO_POSITION_CHECK, '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static byte[] decodeHex(char[] cArr) throws CodecException {
        int length = cArr.length;
        if ((length & 1) == 0) {
            byte[] bArr = new byte[(length >> 1)];
            int i11 = 0;
            int i12 = 0;
            while (i11 < length) {
                int digit = Character.digit(cArr[i11], 16);
                if (digit != -1) {
                    int i13 = i11 + 1;
                    int digit2 = Character.digit(cArr[i13], 16);
                    if (digit2 != -1) {
                        i11 = i13 + 1;
                        bArr[i12] = (byte) (((digit << 4) | digit2) & 255);
                        i12++;
                    } else {
                        throw new CodecException("Illegal hexadecimal character at index " + i13);
                    }
                } else {
                    throw new CodecException("Illegal hexadecimal character at index " + i11);
                }
            }
            return bArr;
        }
        throw new CodecException("Odd number of characters.");
    }

    public static byte[] decodeHexString(String str) throws CodecException {
        return decodeHex(str.toCharArray());
    }

    public static char[] encodeHex(byte[] bArr, boolean z11) {
        return encodeHex(bArr, z11 ? DIGITS_UPPER : DIGITS_LOWER);
    }

    public static char[] encodeHex(byte[] bArr, char[] cArr) {
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

    public static String encodeHexString(byte[] bArr) {
        return encodeHexString(bArr, false);
    }

    public static String encodeHexString(byte[] bArr, boolean z11) {
        return new String(encodeHex(bArr, z11));
    }
}

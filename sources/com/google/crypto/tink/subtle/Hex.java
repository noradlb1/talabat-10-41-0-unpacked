package com.google.crypto.tink.subtle;

import com.google.common.base.Ascii;

public final class Hex {
    private Hex() {
    }

    public static byte[] decode(String str) {
        if (str.length() % 2 == 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i11 = 0; i11 < length; i11++) {
                int i12 = i11 * 2;
                int digit = Character.digit(str.charAt(i12), 16);
                int digit2 = Character.digit(str.charAt(i12 + 1), 16);
                if (digit == -1 || digit2 == -1) {
                    throw new IllegalArgumentException("input is not hexadecimal");
                }
                bArr[i11] = (byte) ((digit * 16) + digit2);
            }
            return bArr;
        }
        throw new IllegalArgumentException("Expected a string of even length");
    }

    public static String encode(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (byte b11 : bArr) {
            byte b12 = b11 & 255;
            sb2.append("0123456789abcdef".charAt(b12 / Ascii.DLE));
            sb2.append("0123456789abcdef".charAt(b12 % Ascii.DLE));
        }
        return sb2.toString();
    }
}

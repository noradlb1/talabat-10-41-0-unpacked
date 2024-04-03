package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.Locale;

@ShowFirstParty
public final class zzdp {
    public static byte[] decode(String str) {
        int length = str.length();
        if (length % 2 == 0) {
            byte[] bArr = new byte[(length / 2)];
            for (int i11 = 0; i11 < length; i11 += 2) {
                int digit = Character.digit(str.charAt(i11), 16);
                int digit2 = Character.digit(str.charAt(i11 + 1), 16);
                if (digit == -1 || digit2 == -1) {
                    throw new IllegalArgumentException("purported base16 string has illegal char");
                }
                bArr[i11 / 2] = (byte) ((digit << 4) + digit2);
            }
            return bArr;
        }
        throw new IllegalArgumentException("purported base16 string has odd number of characters");
    }

    public static String encode(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        for (byte b11 : bArr) {
            if ((b11 & 240) == 0) {
                sb2.append("0");
            }
            sb2.append(Integer.toHexString(b11 & 255));
        }
        return sb2.toString().toUpperCase(Locale.ENGLISH);
    }
}

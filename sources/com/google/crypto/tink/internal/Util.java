package com.google.crypto.tink.internal;

import com.google.common.base.Ascii;
import com.google.crypto.tink.util.Bytes;
import java.security.SecureRandom;
import javax.annotation.Nullable;

public final class Util {
    private Util() {
    }

    @Nullable
    public static Integer getAndroidApiLevel() {
        return BuildDispatchedCode.getApiLevel();
    }

    public static int randKeyId() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[4];
        byte b11 = 0;
        while (b11 == 0) {
            secureRandom.nextBytes(bArr);
            b11 = ((bArr[0] & Byte.MAX_VALUE) << Ascii.CAN) | ((bArr[1] & 255) << Ascii.DLE) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        }
        return b11;
    }

    private static final byte toByteFromPrintableAscii(char c11) {
        if (c11 >= '!' && c11 <= '~') {
            return (byte) c11;
        }
        throw new TinkBugException("Not a printable ASCII character: " + c11);
    }

    public static final Bytes toBytesFromPrintableAscii(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i11 = 0; i11 < str.length(); i11++) {
            bArr[i11] = toByteFromPrintableAscii(str.charAt(i11));
        }
        return Bytes.copyFrom(bArr);
    }
}

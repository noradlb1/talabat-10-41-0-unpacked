package org.tukaani.xz.simple;

import com.google.common.base.Ascii;

public final class PowerPC implements SimpleFilter {
    private final boolean isEncoder;
    private int pos;

    public PowerPC(boolean z11, int i11) {
        this.isEncoder = z11;
        this.pos = i11;
    }

    public int code(byte[] bArr, int i11, int i12) {
        int i13 = (i12 + i11) - 4;
        int i14 = i11;
        while (i14 <= i13) {
            byte b11 = bArr[i14];
            if ((b11 & 252) == 72) {
                int i15 = i14 + 3;
                byte b12 = bArr[i15];
                if ((b12 & 3) == 1) {
                    int i16 = i14 + 1;
                    int i17 = i14 + 2;
                    byte b13 = ((b11 & 3) << Ascii.CAN) | ((bArr[i16] & 255) << Ascii.DLE) | ((bArr[i17] & 255) << 8) | (b12 & 252);
                    int i18 = this.isEncoder ? b13 + ((this.pos + i14) - i11) : b13 - ((this.pos + i14) - i11);
                    bArr[i14] = (byte) (72 | ((i18 >>> 24) & 3));
                    bArr[i16] = (byte) (i18 >>> 16);
                    bArr[i17] = (byte) (i18 >>> 8);
                    bArr[i15] = (byte) (i18 | (bArr[i15] & 3));
                }
            }
            i14 += 4;
        }
        int i19 = i14 - i11;
        this.pos += i19;
        return i19;
    }
}

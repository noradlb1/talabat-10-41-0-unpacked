package org.tukaani.xz.simple;

import com.google.common.base.Ascii;

public final class ARM implements SimpleFilter {
    private final boolean isEncoder;
    private int pos;

    public ARM(boolean z11, int i11) {
        this.isEncoder = z11;
        this.pos = i11 + 8;
    }

    public int code(byte[] bArr, int i11, int i12) {
        int i13 = (i12 + i11) - 4;
        int i14 = i11;
        while (i14 <= i13) {
            if ((bArr[i14 + 3] & 255) == 235) {
                int i15 = i14 + 2;
                int i16 = i14 + 1;
                int i17 = ((((bArr[i15] & 255) << Ascii.DLE) | ((bArr[i16] & 255) << 8)) | (bArr[i14] & 255)) << 2;
                int i18 = (this.isEncoder ? i17 + ((this.pos + i14) - i11) : i17 - ((this.pos + i14) - i11)) >>> 2;
                bArr[i15] = (byte) (i18 >>> 16);
                bArr[i16] = (byte) (i18 >>> 8);
                bArr[i14] = (byte) i18;
            }
            i14 += 4;
        }
        int i19 = i14 - i11;
        this.pos += i19;
        return i19;
    }
}

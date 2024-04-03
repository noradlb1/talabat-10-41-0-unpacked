package org.tukaani.xz.simple;

import com.google.common.base.Ascii;

public final class SPARC implements SimpleFilter {
    private final boolean isEncoder;
    private int pos;

    public SPARC(boolean z11, int i11) {
        this.isEncoder = z11;
        this.pos = i11;
    }

    public int code(byte[] bArr, int i11, int i12) {
        int i13 = (i12 + i11) - 4;
        int i14 = i11;
        while (i14 <= i13) {
            byte b11 = bArr[i14];
            if ((b11 == 64 && (bArr[i14 + 1] & 192) == 0) || (b11 == Byte.MAX_VALUE && (bArr[i14 + 1] & 192) == 192)) {
                int i15 = i14 + 1;
                int i16 = i14 + 2;
                int i17 = i14 + 3;
                int i18 = (((((b11 & 255) << Ascii.CAN) | ((bArr[i15] & 255) << Ascii.DLE)) | ((bArr[i16] & 255) << 8)) | (bArr[i17] & 255)) << 2;
                int i19 = (this.isEncoder ? i18 + ((this.pos + i14) - i11) : i18 - ((this.pos + i14) - i11)) >>> 2;
                int i21 = (i19 & 4194303) | (((0 - ((i19 >>> 22) & 1)) << 22) & 1073741823) | 1073741824;
                bArr[i14] = (byte) (i21 >>> 24);
                bArr[i15] = (byte) (i21 >>> 16);
                bArr[i16] = (byte) (i21 >>> 8);
                bArr[i17] = (byte) i21;
            }
            i14 += 4;
        }
        int i22 = i14 - i11;
        this.pos += i22;
        return i22;
    }
}

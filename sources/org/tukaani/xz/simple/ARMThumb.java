package org.tukaani.xz.simple;

public final class ARMThumb implements SimpleFilter {
    private final boolean isEncoder;
    private int pos;

    public ARMThumb(boolean z11, int i11) {
        this.isEncoder = z11;
        this.pos = i11 + 4;
    }

    public int code(byte[] bArr, int i11, int i12) {
        int i13 = (i12 + i11) - 4;
        int i14 = i11;
        while (i14 <= i13) {
            int i15 = i14 + 1;
            byte b11 = bArr[i15];
            if ((b11 & 248) == 240) {
                int i16 = i14 + 3;
                byte b12 = bArr[i16];
                if ((b12 & 248) == 248) {
                    byte b13 = ((b11 & 7) << 19) | ((bArr[i14] & 255) << 11) | ((b12 & 7) << 8);
                    int i17 = i14 + 2;
                    int i18 = (b13 | (bArr[i17] & 255)) << 1;
                    int i19 = (this.isEncoder ? i18 + ((this.pos + i14) - i11) : i18 - ((this.pos + i14) - i11)) >>> 1;
                    bArr[i15] = (byte) (240 | ((i19 >>> 19) & 7));
                    bArr[i14] = (byte) (i19 >>> 11);
                    bArr[i16] = (byte) (((i19 >>> 8) & 7) | 248);
                    bArr[i17] = (byte) i19;
                    i14 = i17;
                }
            }
            i14 += 2;
        }
        int i21 = i14 - i11;
        this.pos += i21;
        return i21;
    }
}

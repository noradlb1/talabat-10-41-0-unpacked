package org.tukaani.xz.simple;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.common.base.Ascii;

public final class IA64 implements SimpleFilter {
    private static final int[] BRANCH_TABLE = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 6, 6, 0, 0, 7, 7, 4, 4, 0, 0, 4, 4, 0, 0};
    private final boolean isEncoder;
    private int pos;

    public IA64(boolean z11, int i11) {
        this.isEncoder = z11;
        this.pos = i11;
    }

    public int code(byte[] bArr, int i11, int i12) {
        int i13;
        int i14;
        char c11;
        char c12 = 16;
        int i15 = (i11 + i12) - 16;
        int i16 = i11;
        while (i16 <= i15) {
            int i17 = BRANCH_TABLE[bArr[i16] & Ascii.US];
            int i18 = 5;
            int i19 = 0;
            while (i19 < 3) {
                if (((i17 >>> i19) & 1) == 0) {
                    c11 = c12;
                    i14 = i16;
                    i13 = i18;
                } else {
                    int i21 = i18 >>> 3;
                    int i22 = i18 & 7;
                    long j11 = 0;
                    int i23 = 0;
                    while (i23 < 6) {
                        j11 |= (((long) bArr[(i16 + i21) + i23]) & 255) << (i23 * 8);
                        i23++;
                        i16 = i16;
                    }
                    i14 = i16;
                    long j12 = j11 >>> i22;
                    if (((j12 >>> 37) & 15) == 5 && ((j12 >>> 9) & 7) == 0) {
                        i13 = i18;
                        int i24 = (((((int) (j12 >>> 36)) & 1) << 20) | ((int) ((j12 >>> 13) & 1048575))) << 4;
                        long j13 = (long) ((this.isEncoder ? i24 + ((this.pos + i14) - i11) : i24 - ((this.pos + i14) - i11)) >>> 4);
                        c11 = 16;
                        long j14 = ((((j12 & -77309403137L) | ((j13 & 1048575) << 13)) | ((j13 & PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) << 16)) << i22) | (((long) ((1 << i22) - 1)) & j11);
                        for (int i25 = 0; i25 < 6; i25++) {
                            bArr[i14 + i21 + i25] = (byte) ((int) (j14 >>> (i25 * 8)));
                        }
                    } else {
                        i13 = i18;
                        c11 = 16;
                    }
                }
                i19++;
                i18 = i13 + 41;
                c12 = c11;
                i16 = i14;
            }
            char c13 = c12;
            i16 += 16;
        }
        int i26 = i16 - i11;
        this.pos += i26;
        return i26;
    }
}

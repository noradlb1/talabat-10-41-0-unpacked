package com.google.android.gms.internal.auth;

import com.google.common.base.Ascii;

final class zzhl extends zzhk {
    public final int zza(int i11, byte[] bArr, int i12, int i13) {
        while (r9 < i13 && bArr[r9] >= 0) {
            i12 = r9 + 1;
        }
        if (r9 >= i13) {
            return 0;
        }
        while (r9 < i13) {
            int i14 = r9 + 1;
            byte b11 = bArr[r9];
            if (b11 < 0) {
                if (b11 < -32) {
                    if (i14 >= i13) {
                        return b11;
                    }
                    if (b11 >= -62) {
                        r9 = i14 + 1;
                        if (bArr[i14] > -65) {
                        }
                    }
                } else if (b11 < -16) {
                    if (i14 >= i13 - 1) {
                        return zzhm.zza(bArr, i14, i13);
                    }
                    int i15 = i14 + 1;
                    byte b12 = bArr[i14];
                    if (b12 <= -65 && ((b11 != -32 || b12 >= -96) && (b11 != -19 || b12 < -96))) {
                        r9 = i15 + 1;
                        if (bArr[i15] > -65) {
                        }
                    }
                } else if (i14 >= i13 - 2) {
                    return zzhm.zza(bArr, i14, i13);
                } else {
                    int i16 = i14 + 1;
                    byte b13 = bArr[i14];
                    if (b13 <= -65 && (((b11 << Ascii.FS) + (b13 + 112)) >> 30) == 0) {
                        int i17 = i16 + 1;
                        if (bArr[i16] <= -65) {
                            i14 = i17 + 1;
                            if (bArr[i17] > -65) {
                            }
                        }
                    }
                }
                return -1;
            }
            r9 = i14;
        }
        return 0;
    }
}

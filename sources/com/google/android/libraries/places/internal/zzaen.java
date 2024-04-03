package com.google.android.libraries.places.internal;

import com.google.common.base.Ascii;

final class zzaen extends zzaem {
    public final int zza(int i11, byte[] bArr, int i12, int i13) {
        int i14;
        int i15 = 0;
        while (i14 < i13 && bArr[i14] >= 0) {
            i15 = i14 + 1;
        }
        if (i14 >= i13) {
            return 0;
        }
        while (i14 < i13) {
            int i16 = i14 + 1;
            byte b11 = bArr[i14];
            if (b11 < 0) {
                if (b11 < -32) {
                    if (i16 >= i13) {
                        return b11;
                    }
                    if (b11 >= -62) {
                        i14 = i16 + 1;
                        if (bArr[i16] > -65) {
                        }
                    }
                } else if (b11 < -16) {
                    if (i16 >= i13 - 1) {
                        return zzaep.zza(bArr, i16, i13);
                    }
                    int i17 = i16 + 1;
                    byte b12 = bArr[i16];
                    if (b12 <= -65 && ((b11 != -32 || b12 >= -96) && (b11 != -19 || b12 < -96))) {
                        i14 = i17 + 1;
                        if (bArr[i17] > -65) {
                        }
                    }
                } else if (i16 >= i13 - 2) {
                    return zzaep.zza(bArr, i16, i13);
                } else {
                    int i18 = i16 + 1;
                    byte b13 = bArr[i16];
                    if (b13 <= -65 && (((b11 << Ascii.FS) + (b13 + 112)) >> 30) == 0) {
                        int i19 = i18 + 1;
                        if (bArr[i18] <= -65) {
                            i16 = i19 + 1;
                            if (bArr[i19] > -65) {
                            }
                        }
                    }
                }
                return -1;
            }
            i14 = i16;
        }
        return 0;
    }
}

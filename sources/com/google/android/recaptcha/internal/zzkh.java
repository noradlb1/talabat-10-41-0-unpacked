package com.google.android.recaptcha.internal;

import com.google.common.base.Ascii;
import okio.Utf8;

final class zzkh {
    public static /* bridge */ /* synthetic */ void zza(byte b11, byte b12, byte b13, byte b14, char[] cArr, int i11) {
        if (zze(b12) || (((b11 << Ascii.FS) + (b12 + 112)) >> 30) != 0 || zze(b13) || zze(b14)) {
            throw zzhp.zzd();
        }
        byte b15 = b12 & Utf8.REPLACEMENT_BYTE;
        byte b16 = b13 & Utf8.REPLACEMENT_BYTE;
        byte b17 = ((b11 & 7) << Ascii.DC2) | (b15 << 12) | (b16 << 6) | (b14 & Utf8.REPLACEMENT_BYTE);
        cArr[i11] = (char) ((b17 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
        cArr[i11 + 1] = (char) ((b17 & 1023) + Utf8.LOG_SURROGATE_HEADER);
    }

    public static /* bridge */ /* synthetic */ void zzb(byte b11, byte b12, byte b13, char[] cArr, int i11) {
        if (!zze(b12)) {
            if (b11 == -32) {
                if (b12 >= -96) {
                    b11 = -32;
                }
            }
            if (b11 == -19) {
                if (b12 < -96) {
                    b11 = -19;
                }
            }
            if (!zze(b13)) {
                cArr[i11] = (char) (((b11 & Ascii.SI) << 12) | ((b12 & Utf8.REPLACEMENT_BYTE) << 6) | (b13 & Utf8.REPLACEMENT_BYTE));
                return;
            }
        }
        throw zzhp.zzd();
    }

    public static /* bridge */ /* synthetic */ void zzc(byte b11, byte b12, char[] cArr, int i11) {
        if (b11 < -62 || zze(b12)) {
            throw zzhp.zzd();
        }
        cArr[i11] = (char) (((b11 & Ascii.US) << 6) | (b12 & Utf8.REPLACEMENT_BYTE));
    }

    public static /* bridge */ /* synthetic */ boolean zzd(byte b11) {
        return b11 >= 0;
    }

    private static boolean zze(byte b11) {
        return b11 > -65;
    }
}

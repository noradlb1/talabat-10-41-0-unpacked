package com.google.android.gms.internal.vision;

import com.google.common.base.Ascii;
import okio.Utf8;

final class zzju {
    /* access modifiers changed from: private */
    public static void zza(byte b11, char[] cArr, int i11) {
        cArr[i11] = (char) b11;
    }

    /* access modifiers changed from: private */
    public static boolean zzd(byte b11) {
        return b11 >= 0;
    }

    /* access modifiers changed from: private */
    public static boolean zze(byte b11) {
        return b11 < -32;
    }

    /* access modifiers changed from: private */
    public static boolean zzf(byte b11) {
        return b11 < -16;
    }

    private static boolean zzg(byte b11) {
        return b11 > -65;
    }

    /* access modifiers changed from: private */
    public static void zza(byte b11, byte b12, char[] cArr, int i11) throws zzhc {
        if (b11 < -62 || zzg(b12)) {
            throw zzhc.zzgt();
        }
        cArr[i11] = (char) (((b11 & Ascii.US) << 6) | (b12 & Utf8.REPLACEMENT_BYTE));
    }

    /* access modifiers changed from: private */
    public static void zza(byte b11, byte b12, byte b13, char[] cArr, int i11) throws zzhc {
        if (zzg(b12) || ((b11 == -32 && b12 < -96) || ((b11 == -19 && b12 >= -96) || zzg(b13)))) {
            throw zzhc.zzgt();
        }
        cArr[i11] = (char) (((b11 & Ascii.SI) << 12) | ((b12 & Utf8.REPLACEMENT_BYTE) << 6) | (b13 & Utf8.REPLACEMENT_BYTE));
    }

    /* access modifiers changed from: private */
    public static void zza(byte b11, byte b12, byte b13, byte b14, char[] cArr, int i11) throws zzhc {
        if (zzg(b12) || (((b11 << Ascii.FS) + (b12 + 112)) >> 30) != 0 || zzg(b13) || zzg(b14)) {
            throw zzhc.zzgt();
        }
        byte b15 = ((b11 & 7) << Ascii.DC2) | ((b12 & Utf8.REPLACEMENT_BYTE) << 12) | ((b13 & Utf8.REPLACEMENT_BYTE) << 6) | (b14 & Utf8.REPLACEMENT_BYTE);
        cArr[i11] = (char) ((b15 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
        cArr[i11 + 1] = (char) ((b15 & 1023) + Utf8.LOG_SURROGATE_HEADER);
    }
}

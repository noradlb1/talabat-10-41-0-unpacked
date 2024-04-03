package com.google.android.gms.internal.places;

import com.google.common.base.Ascii;
import okio.Utf8;

final class zzdz {
    /* access modifiers changed from: private */
    public static void zzb(byte b11, char[] cArr, int i11) {
        cArr[i11] = (char) b11;
    }

    /* access modifiers changed from: private */
    public static boolean zze(byte b11) {
        return b11 >= 0;
    }

    /* access modifiers changed from: private */
    public static boolean zzf(byte b11) {
        return b11 < -32;
    }

    /* access modifiers changed from: private */
    public static boolean zzg(byte b11) {
        return b11 < -16;
    }

    private static boolean zzh(byte b11) {
        return b11 > -65;
    }

    /* access modifiers changed from: private */
    public static void zzb(byte b11, byte b12, char[] cArr, int i11) throws zzbk {
        if (b11 < -62 || zzh(b12)) {
            throw zzbk.zzbu();
        }
        cArr[i11] = (char) (((b11 & Ascii.US) << 6) | (b12 & Utf8.REPLACEMENT_BYTE));
    }

    /* access modifiers changed from: private */
    public static void zzb(byte b11, byte b12, byte b13, char[] cArr, int i11) throws zzbk {
        if (zzh(b12) || ((b11 == -32 && b12 < -96) || ((b11 == -19 && b12 >= -96) || zzh(b13)))) {
            throw zzbk.zzbu();
        }
        cArr[i11] = (char) (((b11 & Ascii.SI) << 12) | ((b12 & Utf8.REPLACEMENT_BYTE) << 6) | (b13 & Utf8.REPLACEMENT_BYTE));
    }

    /* access modifiers changed from: private */
    public static void zzb(byte b11, byte b12, byte b13, byte b14, char[] cArr, int i11) throws zzbk {
        if (zzh(b12) || (((b11 << Ascii.FS) + (b12 + 112)) >> 30) != 0 || zzh(b13) || zzh(b14)) {
            throw zzbk.zzbu();
        }
        byte b15 = ((b11 & 7) << Ascii.DC2) | ((b12 & Utf8.REPLACEMENT_BYTE) << 12) | ((b13 & Utf8.REPLACEMENT_BYTE) << 6) | (b14 & Utf8.REPLACEMENT_BYTE);
        cArr[i11] = (char) ((b15 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
        cArr[i11 + 1] = (char) ((b15 & 1023) + Utf8.LOG_SURROGATE_HEADER);
    }
}

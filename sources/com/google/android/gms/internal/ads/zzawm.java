package com.google.android.gms.internal.ads;

import android.text.TextUtils;

public final class zzawm {
    public static int zza(int i11, int i12, int i13) {
        if (i11 >= 0 && i11 < i13) {
            return 0;
        }
        throw new IndexOutOfBoundsException();
    }

    public static String zzb(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException();
    }

    public static void zzc(boolean z11) {
        if (!z11) {
            throw new IllegalArgumentException();
        }
    }

    public static void zzd(boolean z11, Object obj) {
        if (!z11) {
            throw new IllegalArgumentException((String) obj);
        }
    }

    public static void zze(boolean z11) {
        if (!z11) {
            throw new IllegalStateException();
        }
    }

    public static void zzf(boolean z11, Object obj) {
        if (!z11) {
            throw new IllegalStateException((String) obj);
        }
    }
}

package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.dataflow.qual.Pure;

public final class zzdy {
    @Pure
    public static int zza(int i11, int i12, int i13) {
        if (i11 >= 0 && i11 < i13) {
            return i11;
        }
        throw new IndexOutOfBoundsException();
    }

    @EnsuresNonNull({"#1"})
    @Pure
    public static <T> T zzb(@Nullable T t11) {
        if (t11 != null) {
            return t11;
        }
        throw new IllegalStateException();
    }

    @EnsuresNonNull({"#1"})
    @Pure
    public static String zzc(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException();
    }

    @Pure
    public static void zzd(boolean z11) {
        if (!z11) {
            throw new IllegalArgumentException();
        }
    }

    @Pure
    public static void zze(boolean z11, Object obj) {
        if (!z11) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    @Pure
    public static void zzf(boolean z11) {
        if (!z11) {
            throw new IllegalStateException();
        }
    }
}

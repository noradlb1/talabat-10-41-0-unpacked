package com.google.android.gms.internal.vision;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class zzcx {
    public static <T> zzcu<T> zza(zzcu<T> zzcu) {
        if ((zzcu instanceof zzcz) || (zzcu instanceof zzcw)) {
            return zzcu;
        }
        if (zzcu instanceof Serializable) {
            return new zzcw(zzcu);
        }
        return new zzcz(zzcu);
    }

    public static <T> zzcu<T> zzd(@NullableDecl T t11) {
        return new zzcy(t11);
    }
}

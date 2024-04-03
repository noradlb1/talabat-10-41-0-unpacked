package com.google.android.gms.internal.vision;

import java.io.Serializable;

public abstract class zzcn<T> implements Serializable {
    public static <T> zzcn<T> zzb(T t11) {
        return new zzcs(zzct.checkNotNull(t11));
    }

    public static <T> zzcn<T> zzbx() {
        return zzck.zzlf;
    }

    public abstract T get();

    public abstract boolean isPresent();
}

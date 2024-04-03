package com.google.android.gms.internal.ads;

import java.util.Comparator;

public abstract class zzfuf<T> implements Comparator<T> {
    public static <T> zzfuf<T> zzb(Comparator<T> comparator) {
        if (comparator instanceof zzfuf) {
            return (zzfuf) comparator;
        }
        return new zzfsd(comparator);
    }

    public static <C extends Comparable> zzfuf<C> zzc() {
        return zzfud.zza;
    }

    public abstract int compare(T t11, T t12);

    public <S extends T> zzfuf<S> zza() {
        return new zzfuo(this);
    }
}

package com.google.android.gms.internal.ads;

public final class zzgps<T> implements zzgpr, zzgpl {
    private static final zzgps<Object> zza = new zzgps<>((Object) null);
    private final T zzb;

    private zzgps(T t11) {
        this.zzb = t11;
    }

    public static <T> zzgpr<T> zza(T t11) {
        zzgpz.zza(t11, "instance cannot be null");
        return new zzgps(t11);
    }

    public static <T> zzgpr<T> zzc(T t11) {
        return t11 == null ? zza : new zzgps(t11);
    }

    public final T zzb() {
        return this.zzb;
    }
}

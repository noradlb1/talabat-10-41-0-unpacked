package com.google.android.gms.internal.consent_sdk;

public final class zzcs<T> implements zzcp<T> {
    private static final zzcs<Object> zza = new zzcs<>((Object) null);
    private final T zzb;

    private zzcs(T t11) {
        this.zzb = t11;
    }

    public static <T> zzcp<T> zza(T t11) {
        return new zzcs(zzcu.zza(t11, "instance cannot be null"));
    }

    public final T zza() {
        return this.zzb;
    }
}

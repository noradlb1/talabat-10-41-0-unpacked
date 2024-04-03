package com.google.android.libraries.places.internal;

public final class zzaet<T> implements zzaeu<T> {
    private static final Object zza = new Object();
    private volatile zzaeu<T> zzb;
    private volatile Object zzc = zza;

    private zzaet(zzaeu<T> zzaeu) {
        this.zzb = zzaeu;
    }

    public static <P extends zzaeu<T>, T> zzaeu<T> zza(P p11) {
        return new zzaet(p11);
    }

    public final T zzb() {
        T t11 = this.zzc;
        if (t11 != zza) {
            return t11;
        }
        if (this.zzb == null) {
            return this.zzc;
        }
        T zze = new zze();
        this.zzc = zze;
        this.zzb = null;
        return zze;
    }
}

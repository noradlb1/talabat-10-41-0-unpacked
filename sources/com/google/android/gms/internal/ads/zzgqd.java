package com.google.android.gms.internal.ads;

public final class zzgqd<T> implements zzgqe<T> {
    private static final Object zza = new Object();
    private volatile zzgqe<T> zzb;
    private volatile Object zzc = zza;

    private zzgqd(zzgqe<T> zzgqe) {
        this.zzb = zzgqe;
    }

    public static <P extends zzgqe<T>, T> zzgqe<T> zza(P p11) {
        if ((p11 instanceof zzgqd) || (p11 instanceof zzgpq)) {
            return p11;
        }
        p11.getClass();
        return new zzgqd(p11);
    }

    public final T zzb() {
        T t11 = this.zzc;
        if (t11 != zza) {
            return t11;
        }
        zzgqe<T> zzgqe = this.zzb;
        if (zzgqe == null) {
            return this.zzc;
        }
        T zzb2 = zzgqe.zzb();
        this.zzc = zzb2;
        this.zzb = null;
        return zzb2;
    }
}

package com.google.android.gms.internal.ads;

public final class zzgpp<T> implements zzgpr<T> {
    private zzgqe<T> zza;

    public static <T> void zza(zzgqe<T> zzgqe, zzgqe<T> zzgqe2) {
        zzgpp zzgpp = (zzgpp) zzgqe;
        if (zzgpp.zza == null) {
            zzgpp.zza = zzgqe2;
            return;
        }
        throw new IllegalStateException();
    }

    public final T zzb() {
        zzgqe<T> zzgqe = this.zza;
        if (zzgqe != null) {
            return zzgqe.zzb();
        }
        throw new IllegalStateException();
    }
}

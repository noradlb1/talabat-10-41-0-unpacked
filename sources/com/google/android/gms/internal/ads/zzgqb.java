package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.List;

public final class zzgqb<T> {
    private final List<zzgqe<T>> zza;
    private final List<zzgqe<Collection<T>>> zzb;

    public /* synthetic */ zzgqb(int i11, int i12, zzgqa zzgqa) {
        this.zza = zzgpo.zzc(i11);
        this.zzb = zzgpo.zzc(i12);
    }

    public final zzgqb<T> zza(zzgqe<? extends Collection<? extends T>> zzgqe) {
        this.zzb.add(zzgqe);
        return this;
    }

    public final zzgqb<T> zzb(zzgqe<? extends T> zzgqe) {
        this.zza.add(zzgqe);
        return this;
    }

    public final zzgqc<T> zzc() {
        return new zzgqc<>(this.zza, this.zzb, (zzgqa) null);
    }
}

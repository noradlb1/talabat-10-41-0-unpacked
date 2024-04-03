package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

public final class zzevr<T> implements zzgpr<zzevq<T>> {
    private final zzgqe<Executor> zza;
    private final zzgqe<Set<zzevn<? extends zzevm<T>>>> zzb;

    public zzevr(zzgqe<Executor> zzgqe, zzgqe<Set<zzevn<? extends zzevm<T>>>> zzgqe2) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
    }

    /* renamed from: zza */
    public final zzevq<T> zzb() {
        zzfxb zzfxb = zzcjm.zza;
        zzgpz.zzb(zzfxb);
        return new zzevq<>(zzfxb, ((zzgqc) this.zzb).zzb());
    }
}

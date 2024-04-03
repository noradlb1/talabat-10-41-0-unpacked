package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzfjt implements zzgpr<zzfjs> {
    private final zzgqe<Executor> zza;
    private final zzgqe<zzcje> zzb;

    public zzfjt(zzgqe<Executor> zzgqe, zzgqe<zzcje> zzgqe2) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfxb zzfxb = zzcjm.zza;
        zzgpz.zzb(zzfxb);
        return new zzfjs(zzfxb, this.zzb.zzb());
    }
}

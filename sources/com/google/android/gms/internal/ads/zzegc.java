package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzegc implements zzgpr<zzdlw<zzfif>> {
    private final zzgqe<zzego> zza;
    private final zzgqe<Executor> zzb;

    public zzegc(zzgqe<zzego> zzgqe, zzgqe<Executor> zzgqe2) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzego zza2 = ((zzegp) this.zza).zzb();
        zzfxb zzfxb = zzcjm.zza;
        zzgpz.zzb(zzfxb);
        return new zzdlw(zza2, zzfxb);
    }
}

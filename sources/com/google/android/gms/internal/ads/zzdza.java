package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzdza implements zzgpr<zzdyz> {
    private final zzgqe<zzdze> zza;
    private final zzgqe<Executor> zzb;

    public zzdza(zzgqe<zzdze> zzgqe, zzgqe<Executor> zzgqe2) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfxb zzfxb = zzcjm.zza;
        zzgpz.zzb(zzfxb);
        return new zzdyz(this.zza.zzb(), zzfxb);
    }
}

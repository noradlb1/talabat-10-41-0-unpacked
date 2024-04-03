package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzekb implements zzgpr<zzeka> {
    private final zzgqe<Context> zza;
    private final zzgqe<zzcjf> zzb;
    private final zzgqe<zzdnt> zzc;
    private final zzgqe<Executor> zzd;

    public zzekb(zzgqe<Context> zzgqe, zzgqe<zzcjf> zzgqe2, zzgqe<zzdnt> zzgqe3, zzgqe<Executor> zzgqe4) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
        this.zzd = zzgqe4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfxb zzfxb = zzcjm.zza;
        zzgpz.zzb(zzfxb);
        return new zzeka(this.zza.zzb(), ((zzcrb) this.zzb).zza(), this.zzc.zzb(), zzfxb);
    }
}

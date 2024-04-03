package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzejj implements zzgpr<zzeji> {
    private final zzgqe<Context> zza;
    private final zzgqe<Executor> zzb;
    private final zzgqe<zzdnt> zzc;
    private final zzgqe<zzfdm> zzd;

    public zzejj(zzgqe<Context> zzgqe, zzgqe<Executor> zzgqe2, zzgqe<zzdnt> zzgqe3, zzgqe<zzfdm> zzgqe4) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
        this.zzd = zzgqe4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzeji(this.zza.zzb(), this.zzb.zzb(), this.zzc.zzb(), this.zzd.zzb());
    }
}

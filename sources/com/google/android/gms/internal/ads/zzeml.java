package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzeml implements zzgpr<zzemk> {
    private final zzgqe<Context> zza;
    private final zzgqe<Executor> zzb;
    private final zzgqe<zzdvs> zzc;

    public zzeml(zzgqe<Context> zzgqe, zzgqe<Executor> zzgqe2, zzgqe<zzdvs> zzgqe3) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzemk(this.zza.zzb(), this.zzb.zzb(), this.zzc.zzb());
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzekq implements zzgpr<zzekp> {
    private final zzgqe<Context> zza;
    private final zzgqe<zzdop> zzb;
    private final zzgqe<Executor> zzc;

    public zzekq(zzgqe<Context> zzgqe, zzgqe<zzdop> zzgqe2, zzgqe<Executor> zzgqe3) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzekp(this.zza.zzb(), this.zzb.zzb(), this.zzc.zzb());
    }
}

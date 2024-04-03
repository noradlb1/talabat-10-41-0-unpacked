package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

public final class zzexl implements zzgpr<zzexj> {
    private final zzgqe<zzcbw> zza;
    private final zzgqe<ScheduledExecutorService> zzb;
    private final zzgqe<Context> zzc;

    public zzexl(zzgqe<zzcbw> zzgqe, zzgqe<ScheduledExecutorService> zzgqe2, zzgqe<Context> zzgqe3) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzexj(new zzcbw(), this.zzb.zzb(), ((zzcqr) this.zzc).zza(), (byte[]) null);
    }
}

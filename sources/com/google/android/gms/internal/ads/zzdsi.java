package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.concurrent.Executor;

public final class zzdsi implements zzgpr<zzdlw<VideoController.VideoLifecycleCallbacks>> {
    private final zzdsb zza;
    private final zzgqe<zzdvi> zzb;
    private final zzgqe<Executor> zzc;

    public zzdsi(zzdsb zzdsb, zzgqe<zzdvi> zzgqe, zzgqe<Executor> zzgqe2) {
        this.zza = zzdsb;
        this.zzb = zzgqe;
        this.zzc = zzgqe2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdlw(((zzdvj) this.zzb).zzb(), this.zzc.zzb());
    }
}

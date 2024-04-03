package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

public final class zzfig implements zzgpr<zzfie> {
    private final zzgqe<zzfxb> zza;
    private final zzgqe<ScheduledExecutorService> zzb;
    private final zzgqe<zzfid> zzc;

    public zzfig(zzgqe<zzfxb> zzgqe, zzgqe<ScheduledExecutorService> zzgqe2, zzgqe<zzfid> zzgqe3) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfxb zzfxb = zzcjm.zza;
        zzgpz.zzb(zzfxb);
        return new zzfie(zzfxb, this.zzb.zzb(), ((zzfih) this.zzc).zzb());
    }
}

package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

public final class zzedc implements zzgpr<zzedb> {
    private final zzgqe<ScheduledExecutorService> zza;
    private final zzgqe<zzfxb> zzb;
    private final zzgqe<zzedt> zzc;
    private final zzgqe<zzefh> zzd;

    public zzedc(zzgqe<ScheduledExecutorService> zzgqe, zzgqe<zzfxb> zzgqe2, zzgqe<zzedt> zzgqe3, zzgqe<zzefh> zzgqe4) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
        this.zzd = zzgqe4;
    }

    /* renamed from: zza */
    public final zzedb zzb() {
        zzfxb zzfxb = zzcjm.zza;
        zzgpz.zzb(zzfxb);
        return new zzedb(this.zza.zzb(), zzfxb, ((zzedu) this.zzc).zzb(), zzgpq.zza(this.zzd));
    }
}

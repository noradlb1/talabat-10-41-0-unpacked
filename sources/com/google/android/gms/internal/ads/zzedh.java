package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

public final class zzedh implements zzgpr<zzedg> {
    private final zzgqe<zzfef> zza;
    private final zzgqe<zzech> zzb;
    private final zzgqe<zzfxb> zzc;
    private final zzgqe<ScheduledExecutorService> zzd;
    private final zzgqe<zzegl> zze;

    public zzedh(zzgqe<zzfef> zzgqe, zzgqe<zzech> zzgqe2, zzgqe<zzfxb> zzgqe3, zzgqe<ScheduledExecutorService> zzgqe4, zzgqe<zzegl> zzgqe5) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
        this.zzd = zzgqe4;
        this.zze = zzgqe5;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfef zza2 = ((zzdei) this.zza).zza();
        zzech zza3 = ((zzeci) this.zzb).zzb();
        zzfxb zzfxb = zzcjm.zza;
        zzgpz.zzb(zzfxb);
        return new zzedg(zza2, zza3, zzfxb, this.zzd.zzb(), this.zze.zzb());
    }
}

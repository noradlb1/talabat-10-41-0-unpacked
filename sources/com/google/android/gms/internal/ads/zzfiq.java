package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

public final class zzfiq implements zzgpr<zzfio> {
    private final zzgqe<zzfiv> zza;
    private final zzgqe<zzfjc> zzb;
    private final zzgqe<ScheduledExecutorService> zzc;

    public zzfiq(zzgqe<zzfiv> zzgqe, zzgqe<zzfjc> zzgqe2, zzgqe<ScheduledExecutorService> zzgqe3) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Object obj;
        zzgpl<zzfiv> zza2 = zzgpq.zza(this.zza);
        zzgpl<zzfjc> zza3 = zzgpq.zza(this.zzb);
        ScheduledExecutorService zzb2 = this.zzc.zzb();
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzgr)).booleanValue()) {
            obj = new zzfis(zza2.zzb(), zzb2);
        } else {
            obj = zza3.zzb();
        }
        zzgpz.zzb(obj);
        return obj;
    }
}

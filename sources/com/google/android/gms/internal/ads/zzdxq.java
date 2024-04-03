package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

public final class zzdxq implements zzgpr<Set<zzdlw<zzfif>>> {
    private final zzgqe<Executor> zza;
    private final zzgqe<zzdyi> zzb;

    public zzdxq(zzgqe<Executor> zzgqe, zzgqe<zzdyi> zzgqe2) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        zzfxb zzfxb = zzcjm.zza;
        zzgpz.zzb(zzfxb);
        zzdyi zza2 = ((zzdyj) this.zzb).zzb();
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzdv)).booleanValue()) {
            set = Collections.singleton(new zzdlw(zza2, zzfxb));
        } else {
            set = Collections.emptySet();
        }
        zzgpz.zzb(set);
        return set;
    }
}

package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

public final class zzcqv implements zzgpr<Set<zzdlw<zzdlk>>> {
    private final zzgqe<zzeft> zza;
    private final zzgqe<Executor> zzb;

    public zzcqv(zzgqe<zzeft> zzgqe, zzgqe<Executor> zzgqe2) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        zzeft zzb2 = this.zza.zzb();
        zzfxb zzfxb = zzcjm.zza;
        zzgpz.zzb(zzfxb);
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzbx)).booleanValue()) {
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzgq)).booleanValue()) {
                set = Collections.singleton(new zzdlw(zzb2, zzfxb));
                zzgpz.zzb(set);
                return set;
            }
        }
        set = Collections.emptySet();
        zzgpz.zzb(set);
        return set;
    }
}

package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

public final class zzczn implements zzgpr<Set<zzdlw<zzaya>>> {
    private final zzczd zza;
    private final zzgqe<zzdan> zzb;

    public zzczn(zzczd zzczd, zzgqe<zzdan> zzgqe) {
        this.zza = zzczd;
        this.zzb = zzgqe;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set singleton = Collections.singleton(new zzdlw(this.zzb.zzb(), zzcjm.zzf));
        zzgpz.zzb(singleton);
        return singleton;
    }
}

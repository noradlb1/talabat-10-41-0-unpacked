package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

public final class zzcxv implements zzgpr<Set<zzdlw<zzdgf>>> {
    private final zzcxt zza;
    private final zzgqe<zzdan> zzb;

    public zzcxv(zzcxt zzcxt, zzgqe<zzdan> zzgqe) {
        this.zza = zzcxt;
        this.zzb = zzgqe;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set singleton = Collections.singleton(new zzdlw(this.zzb.zzb(), zzcjm.zzf));
        zzgpz.zzb(singleton);
        return singleton;
    }
}

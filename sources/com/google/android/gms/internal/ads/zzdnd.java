package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

public final class zzdnd implements zzgpr<Set<zzdlw<zzdjm>>> {
    private final zzdna zza;
    private final zzgqe<zzddr> zzb;

    public zzdnd(zzdna zzdna, zzgqe<zzddr> zzgqe) {
        this.zza = zzdna;
        this.zzb = zzgqe;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set singleton = Collections.singleton(new zzdlw(this.zzb.zzb(), zzcjm.zzf));
        zzgpz.zzb(singleton);
        return singleton;
    }
}

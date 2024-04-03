package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

public final class zzdzn implements zzgpr<Set<zzdlw<zzder>>> {
    private final zzdzm zza;
    private final zzgqe<zzdzw> zzb;
    private final zzgqe<Executor> zzc;

    public zzdzn(zzdzm zzdzm, zzgqe<zzdzw> zzgqe, zzgqe<Executor> zzgqe2) {
        this.zza = zzdzm;
        this.zzb = zzgqe;
        this.zzc = zzgqe2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfxb zzfxb = zzcjm.zza;
        zzgpz.zzb(zzfxb);
        Set<zzdlw<zzder>> zza2 = zzdzm.zza(this.zzb.zzb(), zzfxb);
        zzgpz.zzb(zza2);
        return zza2;
    }
}

package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

public final class zzdzs implements zzgpr<Set<zzdlw<zzaop>>> {
    private final zzdzm zza;
    private final zzgqe<zzdzw> zzb;
    private final zzgqe<Executor> zzc;

    public zzdzs(zzdzm zzdzm, zzgqe<zzdzw> zzgqe, zzgqe<Executor> zzgqe2) {
        this.zza = zzdzm;
        this.zzb = zzgqe;
        this.zzc = zzgqe2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfxb zzfxb = zzcjm.zza;
        zzgpz.zzb(zzfxb);
        Set<zzdlw<zzaop>> zzf = zzdzm.zzf(this.zzb.zzb(), zzfxb);
        zzgpz.zzb(zzf);
        return zzf;
    }
}

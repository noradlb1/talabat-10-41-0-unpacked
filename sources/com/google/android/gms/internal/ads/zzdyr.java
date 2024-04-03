package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzdyr implements zzgpr<zzdlw<zzdgf>> {
    private final zzgqe<zzdym> zza;
    private final zzgqe<Executor> zzb;
    private final zzgqe<zzefr> zzc;

    public zzdyr(zzgqe<zzdym> zzgqe, zzgqe<Executor> zzgqe2, zzgqe<zzefr> zzgqe3) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzdym zzb2 = this.zza.zzb();
        zzfxb zzfxb = zzcjm.zza;
        zzgpz.zzb(zzfxb);
        zzefr zzb3 = this.zzc.zzb();
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzgq)).booleanValue()) {
            return new zzdlw(zzb3, zzfxb);
        }
        return new zzdlw(zzb2, zzfxb);
    }
}

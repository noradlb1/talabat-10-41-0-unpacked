package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzddf implements zzgpr<zzdlw<zzdfl>> {
    private final zzgqe<zzdyk> zza;
    private final zzgqe<Executor> zzb;
    private final zzgqe<zzefp> zzc;

    public zzddf(zzgqe<zzdyk> zzgqe, zzgqe<Executor> zzgqe2, zzgqe<zzefp> zzgqe3) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzdyk zzb2 = this.zza.zzb();
        zzfxb zzfxb = zzcjm.zza;
        zzgpz.zzb(zzfxb);
        zzefp zzb3 = this.zzc.zzb();
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzgq)).booleanValue()) {
            return new zzdlw(zzb3, zzfxb);
        }
        return new zzdlw(zzb2, zzfxb);
    }
}

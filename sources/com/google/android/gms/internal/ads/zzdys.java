package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzdys implements zzgpr<zzdlw<zzfif>> {
    private final zzgqe<zzdzc> zza;
    private final zzgqe<Executor> zzb;
    private final zzgqe<zzefy> zzc;

    public zzdys(zzgqe<zzdzc> zzgqe, zzgqe<Executor> zzgqe2, zzgqe<zzefy> zzgqe3) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzdzc zzb2 = this.zza.zzb();
        zzfxb zzfxb = zzcjm.zza;
        zzgpz.zzb(zzfxb);
        zzefy zzb3 = this.zzc.zzb();
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzgq)).booleanValue()) {
            return new zzdlw(zzb3, zzfxb);
        }
        return new zzdlw(zzb2, zzfxb);
    }
}

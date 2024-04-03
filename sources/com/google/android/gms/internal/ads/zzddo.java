package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzaw;

public final class zzddo implements zzgpr<zzfpv<zzfdn, zzaw>> {
    private final zzgqe<Context> zza;
    private final zzgqe<zzcjf> zzb;
    private final zzgqe<zzfef> zzc;

    public zzddo(zzgqe<Context> zzgqe, zzgqe<zzcjf> zzgqe2, zzgqe<zzfef> zzgqe3) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzddn(this.zza.zzb(), ((zzcrb) this.zzb).zza(), ((zzdei) this.zzc).zza());
    }
}

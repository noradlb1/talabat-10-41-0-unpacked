package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzg;

public final class zzcgh implements zzgpr<zzcgg> {
    private final zzgqe<Context> zza;
    private final zzgqe<zzg> zzb;
    private final zzgqe<zzchh> zzc;

    public zzcgh(zzgqe<Context> zzgqe, zzgqe<zzg> zzgqe2, zzgqe<zzchh> zzgqe3) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcgg(this.zza.zzb(), this.zzb.zzb(), this.zzc.zzb());
    }
}

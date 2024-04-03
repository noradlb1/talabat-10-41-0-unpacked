package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzg;

public final class zzegt implements zzgpr<zzegs> {
    private final zzgqe<Context> zza;
    private final zzgqe<zzddx> zzb;
    private final zzgqe<zzegl> zzc;
    private final zzgqe<zzegh> zzd;
    private final zzgqe<zzg> zze;

    public zzegt(zzgqe<Context> zzgqe, zzgqe<zzddx> zzgqe2, zzgqe<zzegl> zzgqe3, zzgqe<zzegh> zzgqe4, zzgqe<zzg> zzgqe5) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
        this.zzd = zzgqe4;
        this.zze = zzgqe5;
    }

    /* renamed from: zza */
    public final zzegs zzb() {
        return new zzegs(((zzffh) this.zza).zza(), ((zzddy) this.zzb).zzb(), this.zzc.zzb(), ((zzegi) this.zzd).zzb(), ((zzffg) this.zze).zzb());
    }
}

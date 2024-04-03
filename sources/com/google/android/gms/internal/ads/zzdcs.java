package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzb;

public final class zzdcs implements zzgpr<zzb> {
    private final zzdcr zza;
    private final zzgqe<Context> zzb;
    private final zzgqe<zzcgf> zzc;

    public zzdcs(zzdcr zzdcr, zzgqe<Context> zzgqe, zzgqe<zzcgf> zzgqe2) {
        this.zza = zzdcr;
        this.zzb = zzgqe;
        this.zzc = zzgqe2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzb(this.zzb.zzb(), this.zzc.zzb(), (zzcde) null);
    }
}

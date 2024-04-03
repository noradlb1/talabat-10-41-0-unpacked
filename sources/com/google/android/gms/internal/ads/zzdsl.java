package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzbs;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

public final class zzdsl implements zzgpr<zzdsk> {
    private final zzgqe<zzbs> zza;
    private final zzgqe<Clock> zzb;
    private final zzgqe<Executor> zzc;

    public zzdsl(zzgqe<zzbs> zzgqe, zzgqe<Clock> zzgqe2, zzgqe<Executor> zzgqe3) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfxb zzfxb = zzcjm.zza;
        zzgpz.zzb(zzfxb);
        return new zzdsk(this.zza.zzb(), this.zzb.zzb(), zzfxb);
    }
}

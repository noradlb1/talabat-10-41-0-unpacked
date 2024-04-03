package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.common.util.Clock;

public final class zzcgj implements zzgpr<zzcgi> {
    private final zzgqe<Clock> zza;
    private final zzgqe<zzg> zzb;
    private final zzgqe<zzchh> zzc;

    public zzcgj(zzgqe<Clock> zzgqe, zzgqe<zzg> zzgqe2, zzgqe<zzchh> zzgqe3) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcgi(this.zza.zzb(), this.zzb.zzb(), this.zzc.zzb());
    }
}

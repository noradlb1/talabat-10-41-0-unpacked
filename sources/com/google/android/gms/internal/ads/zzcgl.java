package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

public final class zzcgl implements zzgpr<zzcgk> {
    private final zzgqe<Clock> zza;
    private final zzgqe<zzcgi> zzb;

    public zzcgl(zzgqe<Clock> zzgqe, zzgqe<zzcgi> zzgqe2) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
    }

    /* renamed from: zza */
    public final zzcgk zzb() {
        return new zzcgk(this.zza.zzb(), this.zzb.zzb());
    }
}

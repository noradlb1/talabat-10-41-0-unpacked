package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;

public final class zzcyv implements zzgpr<zzdhg> {
    private final zzgqe<ScheduledExecutorService> zza;
    private final zzgqe<Clock> zzb;

    public zzcyv(zzgqe<ScheduledExecutorService> zzgqe, zzgqe<Clock> zzgqe2) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
    }

    /* renamed from: zza */
    public final zzdhg zzb() {
        return new zzdhg(this.zza.zzb(), this.zzb.zzb());
    }
}

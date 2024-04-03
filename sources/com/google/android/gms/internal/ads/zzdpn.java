package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

public final class zzdpn implements zzgpr<zzcxp> {
    private final zzgqe<zzaxw> zza;
    private final zzgqe<Executor> zzb;
    private final zzgqe<Context> zzc;
    private final zzgqe<Clock> zzd;

    public zzdpn(zzgqe<zzaxw> zzgqe, zzgqe<Executor> zzgqe2, zzgqe<Context> zzgqe3, zzgqe<Clock> zzgqe4) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
        this.zzd = zzgqe4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcxp(this.zzb.zzb(), new zzcxb(this.zzc.zzb(), this.zza.zzb()), this.zzd.zzb());
    }
}

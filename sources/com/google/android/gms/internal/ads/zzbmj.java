package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

public final class zzbmj implements zzgpr<zzbmi> {
    private final zzgqe<Context> zza;
    private final zzgqe<ScheduledExecutorService> zzb;
    private final zzgqe<zzbmk> zzc;

    public zzbmj(zzgqe<Context> zzgqe, zzgqe<ScheduledExecutorService> zzgqe2, zzgqe<zzbmk> zzgqe3) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
    }

    public final /* synthetic */ Object zzb() {
        return new zzbmi(((zzffh) this.zza).zza(), this.zzb.zzb(), new zzbmk(), (byte[]) null);
    }
}

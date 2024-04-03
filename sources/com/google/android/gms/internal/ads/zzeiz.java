package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzeiz implements zzgpr<zzeiy> {
    private final zzgqe<Context> zza;
    private final zzgqe<zzczt> zzb;
    private final zzgqe<Executor> zzc;

    public zzeiz(zzgqe<Context> zzgqe, zzgqe<zzczt> zzgqe2, zzgqe<Executor> zzgqe3) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzeiy(this.zza.zzb(), this.zzb.zzb(), this.zzc.zzb());
    }
}

package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzevm;

final class zzerv<S extends zzevm<?>> {
    public final zzfxa<S> zza;
    private final long zzb;
    private final Clock zzc;

    public zzerv(zzfxa<S> zzfxa, long j11, Clock clock) {
        this.zza = zzfxa;
        this.zzc = clock;
        this.zzb = clock.elapsedRealtime() + j11;
    }

    public final boolean zza() {
        return this.zzb < this.zzc.elapsedRealtime();
    }
}

package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzevm;
import java.util.concurrent.atomic.AtomicReference;

public final class zzerw<S extends zzevm> implements zzevn<S> {
    private final AtomicReference<zzerv<S>> zza = new AtomicReference<>();
    private final Clock zzb;
    private final zzevn<S> zzc;
    private final long zzd;

    public zzerw(zzevn<S> zzevn, long j11, Clock clock) {
        this.zzb = clock;
        this.zzc = zzevn;
        this.zzd = j11;
    }

    public final zzfxa<S> zzb() {
        zzerv zzerv = this.zza.get();
        if (zzerv == null || zzerv.zza()) {
            zzerv = new zzerv(this.zzc.zzb(), this.zzd, this.zzb);
            this.zza.set(zzerv);
        }
        return zzerv.zza;
    }
}

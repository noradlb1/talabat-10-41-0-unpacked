package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

public final class zzepz implements zzevn<zzeqa> {
    private final Clock zza;
    private final zzfef zzb;

    public zzepz(Clock clock, zzfef zzfef) {
        this.zza = clock;
        this.zzb = zzfef;
    }

    public final zzfxa<zzeqa> zzb() {
        return zzfwq.zzi(new zzeqa(this.zzb, this.zza.currentTimeMillis()));
    }
}

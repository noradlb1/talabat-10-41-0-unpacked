package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

public final class zzesb implements zzgpr<zzerw<zzerq>> {
    private final zzgqe<zzerp> zza;
    private final zzgqe<Clock> zzb;

    public zzesb(zzgqe<zzerp> zzgqe, zzgqe<Clock> zzgqe2) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzerw(((zzerr) this.zza).zzb(), 10000, this.zzb.zzb());
    }
}

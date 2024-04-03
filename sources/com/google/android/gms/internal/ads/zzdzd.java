package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.Set;

public final class zzdzd implements zzgpr<zzdzc> {
    private final zzgqe<zzdyv> zza;
    private final zzgqe<Set<zzdzb>> zzb;
    private final zzgqe<Clock> zzc;

    public zzdzd(zzgqe<zzdyv> zzgqe, zzgqe<Set<zzdzb>> zzgqe2, zzgqe<Clock> zzgqe3) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdzc(this.zza.zzb(), ((zzgqc) this.zzb).zzb(), this.zzc.zzb());
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;

public final class zzdlz implements zzgpr<zzdly> {
    private final zzgqe<Context> zza;
    private final zzgqe<Set<zzdlw<zzaya>>> zzb;
    private final zzgqe<zzfdn> zzc;

    public zzdlz(zzgqe<Context> zzgqe, zzgqe<Set<zzdlw<zzaya>>> zzgqe2, zzgqe<zzfdn> zzgqe3) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdly(this.zza.zzb(), ((zzgqc) this.zzb).zzb(), ((zzdbl) this.zzc).zza());
    }
}

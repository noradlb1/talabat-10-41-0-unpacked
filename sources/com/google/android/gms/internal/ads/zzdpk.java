package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashSet;

public final class zzdpk implements zzgpr<zzdly> {
    private final zzgqe<Context> zza;
    private final zzgqe<zzfdn> zzb;

    public zzdpk(zzgqe<Context> zzgqe, zzgqe<zzfdn> zzgqe2) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdly(this.zza.zzb(), new HashSet(), ((zzdbl) this.zzb).zza());
    }
}

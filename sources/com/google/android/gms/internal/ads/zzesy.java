package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import java.util.Set;

public final class zzesy implements zzgpr<zzesw> {
    private final zzgqe<zzfxb> zza;
    private final zzgqe<ViewGroup> zzb;
    private final zzgqe<Context> zzc;
    private final zzgqe<Set<String>> zzd;

    public zzesy(zzgqe<zzfxb> zzgqe, zzgqe<ViewGroup> zzgqe2, zzgqe<Context> zzgqe3, zzgqe<Set<String>> zzgqe4) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
        this.zzd = zzgqe4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfxb zzfxb = zzcjm.zza;
        zzgpz.zzb(zzfxb);
        return new zzesw(zzfxb, ((zzcyu) this.zzb).zza(), this.zzc.zzb(), ((zzgqc) this.zzd).zzb());
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzedn implements zzgpr<zzedm> {
    private final zzgqe<zzcqm> zza;
    private final zzgqe<Context> zzb;
    private final zzgqe<zzcjf> zzc;
    private final zzgqe<zzfef> zzd;
    private final zzgqe<Executor> zze;
    private final zzgqe<String> zzf;
    private final zzgqe<zzdhk> zzg;
    private final zzgqe<zzdho> zzh;

    public zzedn(zzgqe<zzcqm> zzgqe, zzgqe<Context> zzgqe2, zzgqe<zzcjf> zzgqe3, zzgqe<zzfef> zzgqe4, zzgqe<Executor> zzgqe5, zzgqe<String> zzgqe6, zzgqe<zzdhk> zzgqe7, zzgqe<zzdho> zzgqe8) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
        this.zzd = zzgqe4;
        this.zze = zzgqe5;
        this.zzf = zzgqe6;
        this.zzg = zzgqe7;
        this.zzh = zzgqe8;
    }

    /* renamed from: zza */
    public final zzedm zzb() {
        Context zza2 = ((zzffh) this.zzb).zza();
        zzcjf zza3 = ((zzcrb) this.zzc).zza();
        zzfef zza4 = ((zzdei) this.zzd).zza();
        zzfxb zzfxb = zzcjm.zza;
        zzgpz.zzb(zzfxb);
        return new zzedm(this.zza.zzb(), zza2, zza3, zza4, zzfxb, this.zzf.zzb(), ((zzdhl) this.zzg).zzb(), ((zzdhp) this.zzh).zzb());
    }
}

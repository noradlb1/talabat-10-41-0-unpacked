package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzg;
import java.util.concurrent.Executor;

public final class zzdrc implements zzgpr<zzdrb> {
    private final zzgqe<zzg> zza;
    private final zzgqe<zzfef> zzb;
    private final zzgqe<zzdqh> zzc;
    private final zzgqe<zzdqc> zzd;
    private final zzgqe<zzdrm> zze;
    private final zzgqe<zzdru> zzf;
    private final zzgqe<Executor> zzg;
    private final zzgqe<Executor> zzh;
    private final zzgqe<zzdpz> zzi;

    public zzdrc(zzgqe<zzg> zzgqe, zzgqe<zzfef> zzgqe2, zzgqe<zzdqh> zzgqe3, zzgqe<zzdqc> zzgqe4, zzgqe<zzdrm> zzgqe5, zzgqe<zzdru> zzgqe6, zzgqe<Executor> zzgqe7, zzgqe<Executor> zzgqe8, zzgqe<zzdpz> zzgqe9) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
        this.zzd = zzgqe4;
        this.zze = zzgqe5;
        this.zzf = zzgqe6;
        this.zzg = zzgqe7;
        this.zzh = zzgqe8;
        this.zzi = zzgqe9;
    }

    /* renamed from: zza */
    public final zzdrb zzb() {
        zzfxb zzfxb = zzcjm.zza;
        zzgpz.zzb(zzfxb);
        return new zzdrb(((zzffg) this.zza).zzb(), ((zzdei) this.zzb).zza(), this.zzc.zzb(), ((zzdqu) this.zzd).zza(), this.zze.zzb(), this.zzf.zzb(), this.zzg.zzb(), zzfxb, this.zzi.zzb());
    }
}

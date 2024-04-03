package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import com.google.android.gms.internal.ads.zzalt;
import com.google.android.gms.internal.ads.zzcjf;
import com.google.android.gms.internal.ads.zzcjm;
import com.google.android.gms.internal.ads.zzcqm;
import com.google.android.gms.internal.ads.zzcqr;
import com.google.android.gms.internal.ads.zzcrb;
import com.google.android.gms.internal.ads.zzduy;
import com.google.android.gms.internal.ads.zzdyz;
import com.google.android.gms.internal.ads.zzfew;
import com.google.android.gms.internal.ads.zzfio;
import com.google.android.gms.internal.ads.zzfjs;
import com.google.android.gms.internal.ads.zzfxb;
import com.google.android.gms.internal.ads.zzgpr;
import com.google.android.gms.internal.ads.zzgpz;
import com.google.android.gms.internal.ads.zzgqe;
import java.util.concurrent.ScheduledExecutorService;

public final class zzw implements zzgpr<zzv> {
    private final zzgqe<zzcqm> zza;
    private final zzgqe<Context> zzb;
    private final zzgqe<zzalt> zzc;
    private final zzgqe<zzfew<zzduy>> zzd;
    private final zzgqe<zzfxb> zze;
    private final zzgqe<ScheduledExecutorService> zzf;
    private final zzgqe<zzdyz> zzg;
    private final zzgqe<zzfio> zzh;
    private final zzgqe<zzfjs> zzi;
    private final zzgqe<zzcjf> zzj;

    public zzw(zzgqe<zzcqm> zzgqe, zzgqe<Context> zzgqe2, zzgqe<zzalt> zzgqe3, zzgqe<zzfew<zzduy>> zzgqe4, zzgqe<zzfxb> zzgqe5, zzgqe<ScheduledExecutorService> zzgqe6, zzgqe<zzdyz> zzgqe7, zzgqe<zzfio> zzgqe8, zzgqe<zzfjs> zzgqe9, zzgqe<zzcjf> zzgqe10) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
        this.zzd = zzgqe4;
        this.zze = zzgqe5;
        this.zzf = zzgqe6;
        this.zzg = zzgqe7;
        this.zzh = zzgqe8;
        this.zzi = zzgqe9;
        this.zzj = zzgqe10;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfxb zzfxb = zzcjm.zza;
        zzgpz.zzb(zzfxb);
        return new zzv(this.zza.zzb(), ((zzcqr) this.zzb).zza(), this.zzc.zzb(), this.zzd.zzb(), zzfxb, this.zzf.zzb(), this.zzg.zzb(), this.zzh.zzb(), this.zzi.zzb(), ((zzcrb) this.zzj).zza());
    }
}

package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

public final class zzexy implements zzgpr<zzexw> {
    private final zzgqe<zzcik> zza;
    private final zzgqe<Boolean> zzb;
    private final zzgqe<zzcia> zzc;
    private final zzgqe<zzfxb> zzd;
    private final zzgqe<String> zze;
    private final zzgqe<ScheduledExecutorService> zzf;

    public zzexy(zzgqe<zzcik> zzgqe, zzgqe<Boolean> zzgqe2, zzgqe<zzcia> zzgqe3, zzgqe<zzfxb> zzgqe4, zzgqe<String> zzgqe5, zzgqe<ScheduledExecutorService> zzgqe6) {
        this.zza = zzgqe;
        this.zzb = zzgqe2;
        this.zzc = zzgqe3;
        this.zzd = zzgqe4;
        this.zze = zzgqe5;
        this.zzf = zzgqe6;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        boolean booleanValue = ((zzexp) this.zzb).zzb().booleanValue();
        zzcia zzcia = new zzcia();
        zzfxb zzfxb = zzcjm.zza;
        zzgpz.zzb(zzfxb);
        return new zzexw(this.zza.zzb(), booleanValue, zzcia, zzfxb, ((zzexn) this.zze).zza(), this.zzf.zzb(), (byte[]) null);
    }
}

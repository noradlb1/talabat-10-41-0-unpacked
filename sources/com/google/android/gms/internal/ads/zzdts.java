package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;

public final class zzdts {
    private final Executor zza;
    private final zzcxp zzb;
    private final zzdly zzc;

    public zzdts(Executor executor, zzcxp zzcxp, zzdly zzdly) {
        this.zza = executor;
        this.zzc = zzdly;
        this.zzb = zzcxp;
    }

    public final void zza(zzcop zzcop) {
        if (zzcop != null) {
            this.zzc.zza(zzcop.zzH());
            this.zzc.zzj(new zzdto(zzcop), this.zza);
            this.zzc.zzj(new zzdtp(zzcop), this.zza);
            this.zzc.zzj(this.zzb, this.zza);
            this.zzb.zzf(zzcop);
            zzcop.zzaf("/trackActiveViewUnit", new zzdtq(this));
            zzcop.zzaf("/untrackActiveViewUnit", new zzdtr(this));
        }
    }

    public final /* synthetic */ void zzb(zzcop zzcop, Map map) {
        this.zzb.zzb();
    }

    public final /* synthetic */ void zzc(zzcop zzcop, Map map) {
        this.zzb.zza();
    }
}

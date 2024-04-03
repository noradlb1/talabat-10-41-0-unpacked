package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;

final class zzbvi implements zzcjv<zzbuo> {
    final /* synthetic */ zzbvs zza;
    final /* synthetic */ zzbvt zzb;

    public zzbvi(zzbvt zzbvt, zzbvs zzbvs) {
        this.zzb = zzbvt;
        this.zza = zzbvs;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        zzbuo zzbuo = (zzbuo) obj;
        synchronized (this.zzb.zza) {
            this.zzb.zzh = 0;
            if (!(this.zzb.zzg == null || this.zza == this.zzb.zzg)) {
                zze.zza("New JS engine is loaded, marking previous one as destroyable.");
                this.zzb.zzg.zzb();
            }
            this.zzb.zzg = this.zza;
        }
    }
}

package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;

final class zzbvj implements zzcjt {
    final /* synthetic */ zzbvs zza;
    final /* synthetic */ zzbvt zzb;

    public zzbvj(zzbvt zzbvt, zzbvs zzbvs) {
        this.zzb = zzbvt;
        this.zza = zzbvs;
    }

    public final void zza() {
        synchronized (this.zzb.zza) {
            this.zzb.zzh = 1;
            zze.zza("Failed loading new engine. Marking new engine destroyable.");
            this.zza.zzb();
        }
    }
}

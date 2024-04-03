package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzb;
import com.google.android.gms.ads.internal.zzt;

final class zzcih extends zzb {
    final /* synthetic */ zzcik zza;

    public zzcih(zzcik zzcik) {
        this.zza = zzcik;
    }

    public final void zza() {
        zzblm zzblm = new zzblm(this.zza.zze, this.zza.zzf.zza);
        synchronized (this.zza.zza) {
            try {
                zzt.zze();
                zzblp.zza(this.zza.zzg, zzblm);
            } catch (IllegalArgumentException e11) {
                zzciz.zzk("Cannot config CSI reporter.", e11);
            }
        }
    }
}

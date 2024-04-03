package com.google.android.gms.internal.ads;

final class zzfdd implements zzepm<zzdvn> {
    final /* synthetic */ zzfde zza;

    public zzfdd(zzfde zzfde) {
        this.zza = zzfde;
    }

    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzf = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdvn zzdvn = (zzdvn) obj;
        synchronized (this.zza) {
            this.zza.zzf = zzdvn;
            this.zza.zzf.zzU();
        }
    }
}

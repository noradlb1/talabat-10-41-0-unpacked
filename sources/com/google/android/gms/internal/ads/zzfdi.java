package com.google.android.gms.internal.ads;

final class zzfdi implements zzepm<zzdvn> {
    final /* synthetic */ zzfdk zza;

    public zzfdi(zzfdk zzfdk) {
        this.zza = zzfdk;
    }

    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzd = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdvn zzdvn = (zzdvn) obj;
        synchronized (this.zza) {
            this.zza.zzd = zzdvn;
            this.zza.zzd.zzU();
        }
    }
}

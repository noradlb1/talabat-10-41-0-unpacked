package com.google.android.gms.internal.ads;

final class zzepe implements zzepm<zzdmw> {
    final /* synthetic */ zzepf zza;

    public zzepe(zzepf zzepf) {
        this.zza = zzepf;
    }

    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzg = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdmw zzdmw = (zzdmw) obj;
        synchronized (this.zza) {
            this.zza.zzg = zzdmw;
            this.zza.zzg.zzU();
        }
    }
}

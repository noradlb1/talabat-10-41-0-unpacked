package com.google.android.gms.internal.ads;

final class zzeod implements zzepm<zzcyw> {
    final /* synthetic */ zzeoe zza;

    public zzeod(zzeoe zzeoe) {
        this.zza = zzeoe;
    }

    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzg = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcyw zzcyw = (zzcyw) obj;
        synchronized (this.zza) {
            if (this.zza.zzg != null) {
                this.zza.zzg.zzT();
            }
            this.zza.zzg = zzcyw;
            this.zza.zzg.zzU();
        }
    }
}

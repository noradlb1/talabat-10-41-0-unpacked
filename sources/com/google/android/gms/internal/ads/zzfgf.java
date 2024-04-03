package com.google.android.gms.internal.ads;

final class zzfgf implements zzfwm<Void> {
    final /* synthetic */ zzfgi zza;
    final /* synthetic */ zzfgj zzb;

    public zzfgf(zzfgj zzfgj, zzfgi zzfgi) {
        this.zzb = zzfgj;
        this.zza = zzfgi;
    }

    public final void zza(Throwable th2) {
        synchronized (this.zzb) {
            this.zzb.zze = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Void voidR = (Void) obj;
        synchronized (this.zzb) {
            this.zzb.zze = null;
            this.zzb.zzd.addFirst(this.zza);
            if (this.zzb.zzf == 1) {
                this.zzb.zzh();
            }
        }
    }
}

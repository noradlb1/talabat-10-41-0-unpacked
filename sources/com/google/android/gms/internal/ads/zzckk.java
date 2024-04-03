package com.google.android.gms.internal.ads;

final class zzckk implements Runnable {
    final /* synthetic */ zzckm zza;

    public zzckk(zzckm zzckm) {
        this.zza = zzckm;
    }

    public final void run() {
        if (this.zza.zzs != null) {
            if (!this.zza.zzt) {
                this.zza.zzs.zzg();
                this.zza.zzt = true;
            }
            this.zza.zzs.zze();
        }
    }
}

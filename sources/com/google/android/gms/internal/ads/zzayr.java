package com.google.android.gms.internal.ads;

final class zzayr implements Runnable {
    final /* synthetic */ zzays zza;

    public zzayr(zzays zzays) {
        this.zza = zzays;
    }

    public final void run() {
        synchronized (this.zza.zzc) {
            if (!this.zza.zzd || !this.zza.zze) {
                zzciz.zze("App is still foreground");
            } else {
                this.zza.zzd = false;
                zzciz.zze("App went background");
                for (zzayt zza2 : this.zza.zzf) {
                    try {
                        zza2.zza(false);
                    } catch (Exception e11) {
                        zzciz.zzh("", e11);
                    }
                }
            }
        }
    }
}

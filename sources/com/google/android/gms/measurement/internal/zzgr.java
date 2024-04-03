package com.google.android.gms.measurement.internal;

final class zzgr implements Runnable {
    final /* synthetic */ zzlk zza;
    final /* synthetic */ zzq zzb;
    final /* synthetic */ zzgv zzc;

    public zzgr(zzgv zzgv, zzlk zzlk, zzq zzq) {
        this.zzc = zzgv;
        this.zza = zzlk;
        this.zzb = zzq;
    }

    public final void run() {
        this.zzc.zza.zzA();
        if (this.zza.zza() == null) {
            this.zzc.zza.zzP(this.zza.zzb, this.zzb);
        } else {
            this.zzc.zza.zzW(this.zza, this.zzb);
        }
    }
}

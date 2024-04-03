package com.google.android.gms.measurement.internal;

final class zzgo implements Runnable {
    final /* synthetic */ zzau zza;
    final /* synthetic */ zzq zzb;
    final /* synthetic */ zzgv zzc;

    public zzgo(zzgv zzgv, zzau zzau, zzq zzq) {
        this.zzc = zzgv;
        this.zza = zzau;
        this.zzb = zzq;
    }

    public final void run() {
        this.zzc.zzv(this.zzc.zzb(this.zza, this.zzb), this.zzb);
    }
}

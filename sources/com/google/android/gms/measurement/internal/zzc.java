package com.google.android.gms.measurement.internal;

final class zzc implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzd zzb;

    public zzc(zzd zzd, long j11) {
        this.zzb = zzd;
        this.zza = j11;
    }

    public final void run() {
        this.zzb.zzj(this.zza);
    }
}

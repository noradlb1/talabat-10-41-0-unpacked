package com.google.android.gms.measurement.internal;

final class zziw implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zziz zzb;

    public zziw(zziz zziz, long j11) {
        this.zzb = zziz;
        this.zza = j11;
    }

    public final void run() {
        this.zzb.zzt.zzd().zzf(this.zza);
        this.zzb.zza = null;
    }
}

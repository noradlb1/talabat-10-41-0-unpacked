package com.google.android.gms.measurement.internal;

final class zzkh implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzkp zzb;

    public zzkh(zzkp zzkp, long j11) {
        this.zzb = zzkp;
        this.zza = j11;
    }

    public final void run() {
        zzkp.zzl(this.zzb, this.zza);
    }
}

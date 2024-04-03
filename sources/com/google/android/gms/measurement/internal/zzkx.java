package com.google.android.gms.measurement.internal;

final class zzkx implements Runnable {
    final /* synthetic */ zzli zza;
    final /* synthetic */ zzlh zzb;

    public zzkx(zzlh zzlh, zzli zzli) {
        this.zzb = zzlh;
        this.zza = zzli;
    }

    public final void run() {
        zzlh.zzy(this.zzb, this.zza);
        this.zzb.zzS();
    }
}

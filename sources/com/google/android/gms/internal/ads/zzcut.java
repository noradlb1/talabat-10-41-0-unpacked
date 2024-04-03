package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzcut implements Runnable {
    public final /* synthetic */ zzcuu zza;
    public final /* synthetic */ Runnable zzb;

    public /* synthetic */ zzcut(zzcuu zzcuu, Runnable runnable) {
        this.zza = zzcuu;
        this.zzb = runnable;
    }

    public final void run() {
        zzcjm.zze.execute(new zzcus(this.zza, this.zzb));
    }
}

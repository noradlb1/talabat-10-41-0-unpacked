package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzcus implements Runnable {
    public final /* synthetic */ zzcuu zza;
    public final /* synthetic */ Runnable zzb;

    public /* synthetic */ zzcus(zzcuu zzcuu, Runnable runnable) {
        this.zza = zzcuu;
        this.zzb = runnable;
    }

    public final void run() {
        this.zza.zzc(this.zzb);
    }
}

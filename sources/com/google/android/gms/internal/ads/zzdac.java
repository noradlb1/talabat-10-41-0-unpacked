package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzdac implements Runnable {
    public final /* synthetic */ zzdae zza;
    public final /* synthetic */ Runnable zzb;

    public /* synthetic */ zzdac(zzdae zzdae, Runnable runnable) {
        this.zza = zzdae;
        this.zzb = runnable;
    }

    public final void run() {
        this.zza.zzk(this.zzb);
    }
}

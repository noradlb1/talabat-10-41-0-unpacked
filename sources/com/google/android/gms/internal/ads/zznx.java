package com.google.android.gms.internal.ads;

public final /* synthetic */ class zznx implements Runnable {
    public final /* synthetic */ zzny zza;
    public final /* synthetic */ Runnable zzb;

    public /* synthetic */ zznx(zzny zzny, Runnable runnable) {
        this.zza = zzny;
        this.zzb = runnable;
    }

    public final void run() {
        this.zza.zzf(this.zzb);
    }
}

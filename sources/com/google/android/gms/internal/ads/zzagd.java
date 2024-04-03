package com.google.android.gms.internal.ads;

final class zzagd implements Runnable {
    final /* synthetic */ zzags zza;
    final /* synthetic */ zzage zzb;

    public zzagd(zzage zzage, zzags zzags) {
        this.zzb = zzage;
        this.zza = zzags;
    }

    public final void run() {
        try {
            this.zzb.zzc.put(this.zza);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}

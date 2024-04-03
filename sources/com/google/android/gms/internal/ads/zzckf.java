package com.google.android.gms.internal.ads;

final class zzckf implements Runnable {
    final /* synthetic */ zzckm zza;

    public zzckf(zzckm zzckm) {
        this.zza = zzckm;
    }

    public final void run() {
        if (this.zza.zzs != null) {
            this.zza.zzs.zza();
        }
    }
}

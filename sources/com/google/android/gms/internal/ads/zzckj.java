package com.google.android.gms.internal.ads;

final class zzckj implements Runnable {
    final /* synthetic */ zzckm zza;

    public zzckj(zzckm zzckm) {
        this.zza = zzckm;
    }

    public final void run() {
        if (this.zza.zzs != null) {
            this.zza.zzs.zzd();
            this.zza.zzs.zzi();
        }
    }
}

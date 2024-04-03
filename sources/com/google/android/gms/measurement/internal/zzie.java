package com.google.android.gms.measurement.internal;

final class zzie implements Runnable {
    final /* synthetic */ Boolean zza;
    final /* synthetic */ zzik zzb;

    public zzie(zzik zzik, Boolean bool) {
        this.zzb = zzik;
        this.zza = bool;
    }

    public final void run() {
        this.zzb.zzaa(this.zza, true);
    }
}

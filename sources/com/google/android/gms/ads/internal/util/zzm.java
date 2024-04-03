package com.google.android.gms.ads.internal.util;

import android.content.Context;

final class zzm implements Runnable {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzt zzb;

    public zzm(zzt zzt, Context context) {
        this.zzb = zzt;
        this.zza = context;
    }

    public final void run() {
        synchronized (this.zzb.zzf) {
            this.zzb.zzg = zzt.zzV(this.zza);
            this.zzb.zzf.notifyAll();
        }
    }
}

package com.google.android.gms.internal.ads;

import android.view.Surface;

final class zzaxs implements Runnable {
    final /* synthetic */ Surface zza;
    final /* synthetic */ zzaxu zzb;

    public zzaxs(zzaxu zzaxu, Surface surface) {
        this.zzb = zzaxu;
        this.zza = surface;
    }

    public final void run() {
        this.zzb.zzb.zzm(this.zza);
    }
}

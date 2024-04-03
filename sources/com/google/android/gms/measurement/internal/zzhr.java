package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

final class zzhr implements Runnable {
    final /* synthetic */ AtomicReference zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzik zzc;

    public zzhr(zzik zzik, AtomicReference atomicReference, boolean z11) {
        this.zzc = zzik;
        this.zza = atomicReference;
        this.zzb = z11;
    }

    public final void run() {
        this.zzc.zzt.zzt().zzx(this.zza, this.zzb);
    }
}

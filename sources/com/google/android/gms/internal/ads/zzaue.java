package com.google.android.gms.internal.ads;

import java.io.IOException;

final class zzaue implements Runnable {
    final /* synthetic */ IOException zza;
    final /* synthetic */ zzaui zzb;

    public zzaue(zzaui zzaui, IOException iOException) {
        this.zzb = zzaui;
        this.zza = iOException;
    }

    public final void run() {
        this.zzb.zze.zzi(this.zza);
    }
}

package com.google.android.gms.internal.ads;

import android.view.View;

final class zzayv implements Runnable {
    final /* synthetic */ View zza;
    final /* synthetic */ zzayz zzb;

    public zzayv(zzayz zzayz, View view) {
        this.zzb = zzayz;
        this.zza = view;
    }

    public final void run() {
        this.zzb.zzc(this.zza);
    }
}

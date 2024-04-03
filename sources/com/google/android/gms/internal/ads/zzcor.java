package com.google.android.gms.internal.ads;

import android.view.View;

public final /* synthetic */ class zzcor implements Runnable {
    public final /* synthetic */ zzcow zza;
    public final /* synthetic */ View zzb;
    public final /* synthetic */ zzcgf zzc;
    public final /* synthetic */ int zzd;

    public /* synthetic */ zzcor(zzcow zzcow, View view, zzcgf zzcgf, int i11) {
        this.zza = zzcow;
        this.zzb = view;
        this.zzc = zzcgf;
        this.zzd = i11;
    }

    public final void run() {
        this.zza.zzn(this.zzb, this.zzc, this.zzd);
    }
}

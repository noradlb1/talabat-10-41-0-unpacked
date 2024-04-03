package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public final /* synthetic */ class zzbjk implements Runnable {
    public final /* synthetic */ zzbjq zza;
    public final /* synthetic */ OnInitializationCompleteListener zzb;

    public /* synthetic */ zzbjk(zzbjq zzbjq, OnInitializationCompleteListener onInitializationCompleteListener) {
        this.zza = zzbjq;
        this.zzb = onInitializationCompleteListener;
    }

    public final void run() {
        this.zza.zzm(this.zzb);
    }
}

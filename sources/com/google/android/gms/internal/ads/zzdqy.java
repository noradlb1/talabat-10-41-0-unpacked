package com.google.android.gms.internal.ads;

import android.view.ViewGroup;

public final /* synthetic */ class zzdqy implements Runnable {
    public final /* synthetic */ zzdrb zza;
    public final /* synthetic */ ViewGroup zzb;

    public /* synthetic */ zzdqy(zzdrb zzdrb, ViewGroup viewGroup) {
        this.zza = zzdrb;
        this.zzb = viewGroup;
    }

    public final void run() {
        this.zza.zza(this.zzb);
    }
}

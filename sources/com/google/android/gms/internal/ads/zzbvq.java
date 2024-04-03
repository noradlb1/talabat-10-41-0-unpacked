package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzbvq implements Runnable {
    public final /* synthetic */ zzbvr zza;
    public final /* synthetic */ zzbuo zzb;

    public /* synthetic */ zzbvq(zzbvr zzbvr, zzbuo zzbuo) {
        this.zza = zzbvr;
        this.zzb = zzbuo;
    }

    public final void run() {
        zzbuo zzbuo = this.zzb;
        zzbuo.zzr("/result", zzbrs.zzo);
        zzbuo.zzc();
    }
}

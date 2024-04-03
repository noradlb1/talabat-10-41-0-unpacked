package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzbvd implements Runnable {
    public final /* synthetic */ zzbvt zza;
    public final /* synthetic */ zzbvs zzb;
    public final /* synthetic */ zzbuo zzc;

    public /* synthetic */ zzbvd(zzbvt zzbvt, zzbvs zzbvs, zzbuo zzbuo) {
        this.zza = zzbvt;
        this.zzb = zzbvs;
        this.zzc = zzbuo;
    }

    public final void run() {
        this.zza.zzh(this.zzb, this.zzc);
    }
}

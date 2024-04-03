package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzcgt implements Runnable {
    public final /* synthetic */ zzchh zza;
    public final /* synthetic */ zzchg zzb;
    public final /* synthetic */ String zzc;

    public /* synthetic */ zzcgt(zzchh zzchh, zzchg zzchg, String str) {
        this.zza = zzchh;
        this.zzb = zzchg;
        this.zzc = str;
    }

    public final void run() {
        this.zza.zzj(this.zzb, this.zzc);
    }
}

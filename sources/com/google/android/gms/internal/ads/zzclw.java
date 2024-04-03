package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzclw implements Runnable {
    public final /* synthetic */ zzcly zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ int zzc;

    public /* synthetic */ zzclw(zzcly zzcly, int i11, int i12) {
        this.zza = zzcly;
        this.zzb = i11;
        this.zzc = i12;
    }

    public final void run() {
        this.zza.zzN(this.zzb, this.zzc);
    }
}

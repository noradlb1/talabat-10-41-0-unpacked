package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzclo implements Runnable {
    public final /* synthetic */ zzcly zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ long zzc;

    public /* synthetic */ zzclo(zzcly zzcly, boolean z11, long j11) {
        this.zza = zzcly;
        this.zzb = z11;
        this.zzc = j11;
    }

    public final void run() {
        this.zza.zzI(this.zzb, this.zzc);
    }
}

package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzcnm implements Runnable {
    public final /* synthetic */ zzclh zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ long zzc;

    public /* synthetic */ zzcnm(zzclh zzclh, boolean z11, long j11) {
        this.zza = zzclh;
        this.zzb = z11;
        this.zzc = j11;
    }

    public final void run() {
        this.zza.zzx(this.zzb, this.zzc);
    }
}

package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzlq implements Runnable {
    public final /* synthetic */ zzls zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ long zzc;
    public final /* synthetic */ long zzd;

    public /* synthetic */ zzlq(zzls zzls, String str, long j11, long j12) {
        this.zza = zzls;
        this.zzb = str;
        this.zzc = j11;
        this.zzd = j12;
    }

    public final void run() {
        this.zza.zzj(this.zzb, this.zzc, this.zzd);
    }
}

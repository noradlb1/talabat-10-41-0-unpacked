package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzli implements Runnable {
    public final /* synthetic */ zzls zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ long zzc;
    public final /* synthetic */ long zzd;

    public /* synthetic */ zzli(zzls zzls, int i11, long j11, long j12) {
        this.zza = zzls;
        this.zzb = i11;
        this.zzc = j11;
        this.zzd = j12;
    }

    public final void run() {
        this.zza.zzq(this.zzb, this.zzc, this.zzd);
    }
}

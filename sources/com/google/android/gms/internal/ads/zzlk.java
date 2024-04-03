package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzlk implements Runnable {
    public final /* synthetic */ zzls zza;
    public final /* synthetic */ zzab zzb;
    public final /* synthetic */ zzfz zzc;

    public /* synthetic */ zzlk(zzls zzls, zzab zzab, zzfz zzfz) {
        this.zza = zzls;
        this.zzb = zzab;
        this.zzc = zzfz;
    }

    public final void run() {
        this.zza.zzn(this.zzb, this.zzc);
    }
}

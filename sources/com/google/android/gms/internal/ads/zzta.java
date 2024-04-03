package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzta implements Runnable {
    public final /* synthetic */ zztb zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ long zzc;
    public final /* synthetic */ long zzd;

    public /* synthetic */ zzta(zztb zztb, int i11, long j11, long j12) {
        this.zza = zztb;
        this.zzb = i11;
        this.zzc = j11;
        this.zzd = j12;
    }

    public final void run() {
        zztb zztb = this.zza;
        zztb.zzb.zzS(this.zzb, this.zzc, this.zzd);
    }
}

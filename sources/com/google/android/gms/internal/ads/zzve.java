package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzve implements Runnable {
    public final /* synthetic */ zzvo zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ long zzc;

    public /* synthetic */ zzve(zzvo zzvo, int i11, long j11) {
        this.zza = zzvo;
        this.zzb = i11;
        this.zzc = j11;
    }

    public final void run() {
        this.zza.zzj(this.zzb, this.zzc);
    }
}

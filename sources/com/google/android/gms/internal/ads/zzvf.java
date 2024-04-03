package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzvf implements Runnable {
    public final /* synthetic */ zzvo zza;
    public final /* synthetic */ long zzb;
    public final /* synthetic */ int zzc;

    public /* synthetic */ zzvf(zzvo zzvo, long j11, int i11) {
        this.zza = zzvo;
        this.zzb = j11;
        this.zzc = i11;
    }

    public final void run() {
        this.zza.zzn(this.zzb, this.zzc);
    }
}

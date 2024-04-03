package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzvl implements Runnable {
    public final /* synthetic */ zzvo zza;
    public final /* synthetic */ Object zzb;
    public final /* synthetic */ long zzc;

    public /* synthetic */ zzvl(zzvo zzvo, Object obj, long j11) {
        this.zza = zzvo;
        this.zzb = obj;
        this.zzc = j11;
    }

    public final void run() {
        this.zza.zzm(this.zzb, this.zzc);
    }
}

package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzvg implements Runnable {
    public final /* synthetic */ zzvo zza;
    public final /* synthetic */ zzab zzb;
    public final /* synthetic */ zzfz zzc;

    public /* synthetic */ zzvg(zzvo zzvo, zzab zzab, zzfz zzfz) {
        this.zza = zzvo;
        this.zzb = zzab;
        this.zzc = zzfz;
    }

    public final void run() {
        this.zza.zzl(this.zzb, this.zzc);
    }
}

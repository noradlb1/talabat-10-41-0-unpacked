package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzvn implements Runnable {
    public final /* synthetic */ zzvo zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ long zzc;
    public final /* synthetic */ long zzd;

    public /* synthetic */ zzvn(zzvo zzvo, String str, long j11, long j12) {
        this.zza = zzvo;
        this.zzb = str;
        this.zzc = j11;
        this.zzd = j12;
    }

    public final void run() {
        this.zza.zzg(this.zzb, this.zzc, this.zzd);
    }
}

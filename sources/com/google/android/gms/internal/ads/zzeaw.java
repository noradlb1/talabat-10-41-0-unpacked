package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzeaw implements Runnable {
    public final /* synthetic */ zzebb zza;
    public final /* synthetic */ Object zzb;
    public final /* synthetic */ zzcjr zzc;
    public final /* synthetic */ String zzd;
    public final /* synthetic */ long zze;

    public /* synthetic */ zzeaw(zzebb zzebb, Object obj, zzcjr zzcjr, String str, long j11) {
        this.zza = zzebb;
        this.zzb = obj;
        this.zzc = zzcjr;
        this.zzd = str;
        this.zze = j11;
    }

    public final void run() {
        this.zza.zzp(this.zzb, this.zzc, this.zzd, this.zze);
    }
}

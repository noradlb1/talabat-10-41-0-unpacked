package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzemh implements Runnable {
    public final /* synthetic */ zzemi zza;
    public final /* synthetic */ zzfdz zzb;
    public final /* synthetic */ zzfdn zzc;
    public final /* synthetic */ zzehw zzd;

    public /* synthetic */ zzemh(zzemi zzemi, zzfdz zzfdz, zzfdn zzfdn, zzehw zzehw) {
        this.zza = zzemi;
        this.zzb = zzfdz;
        this.zzc = zzfdn;
        this.zzd = zzehw;
    }

    public final void run() {
        zzemi zzemi = this.zza;
        zzemk.zze(this.zzb, this.zzc, this.zzd);
    }
}

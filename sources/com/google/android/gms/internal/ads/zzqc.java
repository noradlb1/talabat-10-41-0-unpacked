package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzqc implements Runnable {
    public final /* synthetic */ zzqi zza;
    public final /* synthetic */ zzqj zzb;
    public final /* synthetic */ zzpr zzc;
    public final /* synthetic */ zzpw zzd;

    public /* synthetic */ zzqc(zzqi zzqi, zzqj zzqj, zzpr zzpr, zzpw zzpw) {
        this.zza = zzqi;
        this.zzb = zzqj;
        this.zzc = zzpr;
        this.zzd = zzpw;
    }

    public final void run() {
        zzqi zzqi = this.zza;
        this.zzb.zzbf(zzqi.zza, zzqi.zzb, this.zzc, this.zzd);
    }
}

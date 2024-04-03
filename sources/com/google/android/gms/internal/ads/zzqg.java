package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzqg implements Runnable {
    public final /* synthetic */ zzqi zza;
    public final /* synthetic */ zzqj zzb;
    public final /* synthetic */ zzpw zzc;

    public /* synthetic */ zzqg(zzqi zzqi, zzqj zzqj, zzpw zzpw) {
        this.zza = zzqi;
        this.zzb = zzqj;
        this.zzc = zzpw;
    }

    public final void run() {
        zzqi zzqi = this.zza;
        this.zzb.zzbe(zzqi.zza, zzqi.zzb, this.zzc);
    }
}

package com.google.android.gms.internal.ads;

import java.io.IOException;

public final /* synthetic */ class zzqf implements Runnable {
    public final /* synthetic */ zzqi zza;
    public final /* synthetic */ zzqj zzb;
    public final /* synthetic */ zzpr zzc;
    public final /* synthetic */ zzpw zzd;
    public final /* synthetic */ IOException zze;
    public final /* synthetic */ boolean zzf;

    public /* synthetic */ zzqf(zzqi zzqi, zzqj zzqj, zzpr zzpr, zzpw zzpw, IOException iOException, boolean z11) {
        this.zza = zzqi;
        this.zzb = zzqj;
        this.zzc = zzpr;
        this.zzd = zzpw;
        this.zze = iOException;
        this.zzf = z11;
    }

    public final void run() {
        zzqi zzqi = this.zza;
        this.zzb.zzd(zzqi.zza, zzqi.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }
}

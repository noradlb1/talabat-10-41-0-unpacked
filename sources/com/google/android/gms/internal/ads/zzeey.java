package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

public final /* synthetic */ class zzeey implements Callable {
    public final /* synthetic */ zzefh zza;
    public final /* synthetic */ zzfxa zzb;
    public final /* synthetic */ zzfxa zzc;
    public final /* synthetic */ zzcdq zzd;

    public /* synthetic */ zzeey(zzefh zzefh, zzfxa zzfxa, zzfxa zzfxa2, zzcdq zzcdq) {
        this.zza = zzefh;
        this.zzb = zzfxa;
        this.zzc = zzfxa2;
        this.zzd = zzcdq;
    }

    public final Object call() {
        return this.zza.zzj(this.zzb, this.zzc, this.zzd);
    }
}

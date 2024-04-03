package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

public final /* synthetic */ class zzddw implements Callable {
    public final /* synthetic */ zzddx zza;
    public final /* synthetic */ zzfxa zzb;

    public /* synthetic */ zzddw(zzddx zzddx, zzfxa zzfxa) {
        this.zza = zzddx;
        this.zzb = zzfxa;
    }

    public final Object call() {
        return this.zza.zza(this.zzb);
    }
}

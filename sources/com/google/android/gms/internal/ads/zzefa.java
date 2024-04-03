package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

public final /* synthetic */ class zzefa implements Callable {
    public final /* synthetic */ zzfxa zza;
    public final /* synthetic */ zzfxa zzb;

    public /* synthetic */ zzefa(zzfxa zzfxa, zzfxa zzfxa2) {
        this.zza = zzfxa;
        this.zzb = zzfxa2;
    }

    public final Object call() {
        zzfxa zzfxa = this.zza;
        zzfxa zzfxa2 = this.zzb;
        return new zzefg((zzefk) zzfxa.get(), ((zzefe) zzfxa2.get()).zzb, ((zzefe) zzfxa2.get()).zza);
    }
}

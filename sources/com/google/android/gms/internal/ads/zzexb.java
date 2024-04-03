package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

public final /* synthetic */ class zzexb implements Callable {
    public final /* synthetic */ zzfxa zza;
    public final /* synthetic */ zzfxa zzb;

    public /* synthetic */ zzexb(zzfxa zzfxa, zzfxa zzfxa2) {
        this.zza = zzfxa;
        this.zzb = zzfxa2;
    }

    public final Object call() {
        return new zzexd((String) this.zza.get(), (String) this.zzb.get());
    }
}

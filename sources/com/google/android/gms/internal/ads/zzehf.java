package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

public final /* synthetic */ class zzehf implements Callable {
    public final /* synthetic */ zzehh zza;

    public /* synthetic */ zzehf(zzehh zzehh) {
        this.zza = zzehh;
    }

    public final Object call() {
        return this.zza.getWritableDatabase();
    }
}

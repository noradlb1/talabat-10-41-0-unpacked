package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

public final /* synthetic */ class zzegf implements Callable {
    public final /* synthetic */ zzegd zza;

    public /* synthetic */ zzegf(zzegd zzegd) {
        this.zza = zzegd;
    }

    public final Object call() {
        return this.zza.getWritableDatabase();
    }
}

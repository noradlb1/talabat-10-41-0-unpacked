package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public final class zzfwp<V> {
    private final boolean zza;
    private final zzfss<zzfxa<? extends V>> zzb;

    public /* synthetic */ zzfwp(boolean z11, zzfss zzfss, zzfwo zzfwo) {
        this.zza = z11;
        this.zzb = zzfss;
    }

    public final <C> zzfxa<C> zza(Callable<C> callable, Executor executor) {
        return new zzfwd(this.zzb, this.zza, executor, callable);
    }
}

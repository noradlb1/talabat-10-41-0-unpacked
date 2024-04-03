package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

final class zzfwb extends zzfwc {
    final /* synthetic */ zzfwd zza;
    private final Callable zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfwb(zzfwd zzfwd, Callable callable, Executor executor) {
        super(zzfwd, executor);
        this.zza = zzfwd;
        callable.getClass();
        this.zzc = callable;
    }

    public final Object zza() throws Exception {
        return this.zzc.call();
    }

    public final String zzb() {
        return this.zzc.toString();
    }

    public final void zzc(Object obj) {
        this.zza.zzs(obj);
    }
}

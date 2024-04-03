package com.google.android.gms.internal.ads;

import java.lang.Throwable;

final class zzfvc<V, X extends Throwable> extends zzfve<V, X, zzfvx<? super X, ? extends V>, zzfxa<? extends V>> {
    public zzfvc(zzfxa<? extends V> zzfxa, Class<X> cls, zzfvx<? super X, ? extends V> zzfvx) {
        super(zzfxa, cls, zzfvx);
    }

    public final /* bridge */ /* synthetic */ Object zza(Object obj, Throwable th2) throws Exception {
        zzfvx zzfvx = (zzfvx) obj;
        zzfxa zza = zzfvx.zza(th2);
        zzfqg.zzd(zza, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzfvx);
        return zza;
    }

    public final /* synthetic */ void zzb(Object obj) {
        zzu((zzfxa) obj);
    }
}

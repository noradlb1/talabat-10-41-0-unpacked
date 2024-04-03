package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;

public final class zzfhm {
    final /* synthetic */ zzfhw zza;
    private final Object zzb;
    private final List<zzfxa<?>> zzc;

    public /* synthetic */ zzfhm(zzfhw zzfhw, Object obj, List list, zzfhl zzfhl) {
        this.zza = zzfhw;
        this.zzb = obj;
        this.zzc = list;
    }

    public final <O> zzfhv<O> zza(Callable<O> callable) {
        zzfwp<V> zzc2 = zzfwq.zzc(this.zzc);
        zzfxa<C> zza2 = zzc2.zza(zzfhk.zza, zzcjm.zzf);
        zzfhw zzfhw = this.zza;
        return new zzfhv(zzfhw, this.zzb, (String) null, zza2, this.zzc, zzc2.zza(callable, zzfhw.zzb), (zzfhu) null);
    }
}

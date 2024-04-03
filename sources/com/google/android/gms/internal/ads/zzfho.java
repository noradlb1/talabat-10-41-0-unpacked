package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.concurrent.Callable;

public final class zzfho {
    public static final <O> zzfhv<O> zza(Callable<O> callable, Object obj, zzfhw zzfhw) {
        return zzb(callable, zzfhw.zzb, obj, zzfhw);
    }

    public static final <O> zzfhv<O> zzb(Callable<O> callable, zzfxb zzfxb, Object obj, zzfhw zzfhw) {
        return new zzfhv(zzfhw, obj, (String) null, zzfhw.zza, Collections.emptyList(), zzfxb.zzb(callable), (zzfhu) null);
    }

    public static final <O> zzfhv<O> zzc(zzfxa<O> zzfxa, Object obj, zzfhw zzfhw) {
        return new zzfhv(zzfhw, obj, (String) null, zzfhw.zza, Collections.emptyList(), zzfxa, (zzfhu) null);
    }

    public static final zzfhv zzd(zzfhi zzfhi, zzfxb zzfxb, Object obj, zzfhw zzfhw) {
        return zzb(new zzfhn(zzfhi), zzfxb, obj, zzfhw);
    }
}

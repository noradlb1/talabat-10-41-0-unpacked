package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;

public abstract class zzfhw<E> {
    /* access modifiers changed from: private */
    public static final zzfxa<?> zza = zzfwq.zzi(null);
    /* access modifiers changed from: private */
    public final zzfxb zzb;
    /* access modifiers changed from: private */
    public final ScheduledExecutorService zzc;
    /* access modifiers changed from: private */
    public final zzfhx<E> zzd;

    public zzfhw(zzfxb zzfxb, ScheduledExecutorService scheduledExecutorService, zzfhx<E> zzfhx) {
        this.zzb = zzfxb;
        this.zzc = scheduledExecutorService;
        this.zzd = zzfhx;
    }

    public final zzfhm zza(E e11, zzfxa<?>... zzfxaArr) {
        return new zzfhm(this, e11, Arrays.asList(zzfxaArr), (zzfhl) null);
    }

    public final <I> zzfhv<I> zzb(E e11, zzfxa<I> zzfxa) {
        return new zzfhv(this, e11, (String) null, zzfxa, Collections.singletonList(zzfxa), zzfxa, (zzfhu) null);
    }

    public abstract String zzf(E e11);
}

package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import javax.annotation.CheckForNull;
import v0.a;

final class zzfvs extends zzfvr {
    final AtomicReferenceFieldUpdater<zzfvv<?>, Set<Throwable>> zza;
    final AtomicIntegerFieldUpdater<zzfvv<?>> zzb;

    public zzfvs(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
        super((zzfvq) null);
        this.zza = atomicReferenceFieldUpdater;
        this.zzb = atomicIntegerFieldUpdater;
    }

    public final int zza(zzfvv<?> zzfvv) {
        return this.zzb.decrementAndGet(zzfvv);
    }

    public final void zzb(zzfvv<?> zzfvv, @CheckForNull Set<Throwable> set, Set<Throwable> set2) {
        a.a(this.zza, zzfvv, (Object) null, set2);
    }
}

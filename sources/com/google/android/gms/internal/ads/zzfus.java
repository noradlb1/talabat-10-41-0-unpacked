package com.google.android.gms.internal.ads;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;

abstract class zzfus<F, T> implements Iterator<T>, j$.util.Iterator {
    final Iterator<? extends F> zzb;

    public zzfus(Iterator<? extends F> it) {
        it.getClass();
        this.zzb = it;
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final boolean hasNext() {
        return this.zzb.hasNext();
    }

    public final T next() {
        return zza(this.zzb.next());
    }

    public final void remove() {
        this.zzb.remove();
    }

    /* access modifiers changed from: package-private */
    public abstract T zza(F f11);
}

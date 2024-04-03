package com.google.android.libraries.places.internal;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;

abstract class zzgy<F, T> implements Iterator<T>, j$.util.Iterator {
    final Iterator<? extends F> zzb;

    public zzgy(Iterator<? extends F> it) {
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

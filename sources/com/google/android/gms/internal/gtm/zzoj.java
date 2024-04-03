package com.google.android.gms.internal.gtm;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;

final class zzoj implements Iterator<zzoa<?>>, j$.util.Iterator {
    private final /* synthetic */ Iterator zzaur;
    private final /* synthetic */ Iterator zzaus;

    public zzoj(zzoh zzoh, Iterator it, Iterator it2) {
        this.zzaur = it;
        this.zzaus = it2;
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final boolean hasNext() {
        return this.zzaur.hasNext() || this.zzaus.hasNext();
    }

    public final /* synthetic */ Object next() {
        if (this.zzaur.hasNext()) {
            return (zzoa) this.zzaur.next();
        }
        return (zzoa) this.zzaus.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

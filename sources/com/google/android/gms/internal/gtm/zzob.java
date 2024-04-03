package com.google.android.gms.internal.gtm;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;

final class zzob implements Iterator<zzoa<?>>, j$.util.Iterator {
    private final /* synthetic */ Iterator zzaue;

    public zzob(zzoa zzoa, Iterator it) {
        this.zzaue = it;
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final boolean hasNext() {
        return this.zzaue.hasNext();
    }

    public final /* synthetic */ Object next() {
        return new zzom((String) this.zzaue.next());
    }

    public final void remove() {
        this.zzaue.remove();
    }
}

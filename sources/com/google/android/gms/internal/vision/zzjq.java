package com.google.android.gms.internal.vision;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;

final class zzjq implements Iterator<String>, j$.util.Iterator {
    private final /* synthetic */ zzjo zzaan;
    private Iterator<String> zzabj;

    public zzjq(zzjo zzjo) {
        this.zzaan = zzjo;
        this.zzabj = zzjo.zzaao.iterator();
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final boolean hasNext() {
        return this.zzabj.hasNext();
    }

    public final /* synthetic */ Object next() {
        return this.zzabj.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

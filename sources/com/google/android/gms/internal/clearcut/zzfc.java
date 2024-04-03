package com.google.android.gms.internal.clearcut;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;

final class zzfc implements Iterator<String>, j$.util.Iterator {
    private final /* synthetic */ zzfa zzpe;
    private Iterator<String> zzpf;

    public zzfc(zzfa zzfa) {
        this.zzpe = zzfa;
        this.zzpf = zzfa.zzpb.iterator();
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final boolean hasNext() {
        return this.zzpf.hasNext();
    }

    public final /* synthetic */ Object next() {
        return this.zzpf.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

package com.google.android.gms.internal.places;

import j$.util.Iterator;
import j$.util.function.Consumer;

abstract class zzx implements zzab, Iterator {
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public /* synthetic */ Object next() {
        return Byte.valueOf(nextByte());
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

package com.google.android.gms.internal.gtm;

import j$.util.Iterator;
import j$.util.function.Consumer;

abstract class zzpv implements zzpz, Iterator {
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

package com.google.android.libraries.places.internal;

import j$.util.Iterator;
import j$.util.function.Consumer;

abstract class zzaaq implements zzaas, Iterator {
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return Byte.valueOf(zza());
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

package com.google.android.gms.internal.icing;

import j$.util.Iterator;
import j$.util.function.Consumer;

abstract class zzbz implements zzcb, Iterator {
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

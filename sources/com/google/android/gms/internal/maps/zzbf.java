package com.google.android.gms.internal.maps;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;

public abstract class zzbf implements Iterator, j$.util.Iterator {
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

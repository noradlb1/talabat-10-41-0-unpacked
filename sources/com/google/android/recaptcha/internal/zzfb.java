package com.google.android.recaptcha.internal;

import j$.util.Iterator;
import j$.util.function.Consumer;

abstract class zzfb implements zzfd, Iterator {
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final /* synthetic */ Object next() {
        return Byte.valueOf(zza());
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

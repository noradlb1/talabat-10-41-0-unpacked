package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.DoNotCall;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class UnmodifiableIterator<E> implements Iterator<E>, j$.util.Iterator {
    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

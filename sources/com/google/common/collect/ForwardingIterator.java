package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingIterator<T> extends ForwardingObject implements Iterator<T>, j$.util.Iterator {
    public abstract Iterator<T> delegate();

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public boolean hasNext() {
        return delegate().hasNext();
    }

    @ParametricNullness
    @CanIgnoreReturnValue
    public T next() {
        return delegate().next();
    }

    public void remove() {
        delegate().remove();
    }
}

package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;

@GwtCompatible
@ElementTypesAreNonnullByDefault
abstract class TransformedIterator<F, T> implements Iterator<T>, j$.util.Iterator {
    final Iterator<? extends F> backingIterator;

    public TransformedIterator(Iterator<? extends F> it) {
        this.backingIterator = (Iterator) Preconditions.checkNotNull(it);
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final boolean hasNext() {
        return this.backingIterator.hasNext();
    }

    @ParametricNullness
    public final T next() {
        return transform(this.backingIterator.next());
    }

    public final void remove() {
        this.backingIterator.remove();
    }

    @ParametricNullness
    public abstract T transform(@ParametricNullness F f11);
}

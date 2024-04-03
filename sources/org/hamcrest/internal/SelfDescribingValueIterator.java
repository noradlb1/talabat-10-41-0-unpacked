package org.hamcrest.internal;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import org.hamcrest.SelfDescribing;

public class SelfDescribingValueIterator<T> implements Iterator<SelfDescribing>, j$.util.Iterator {
    private Iterator<T> values;

    public SelfDescribingValueIterator(Iterator<T> it) {
        this.values = it;
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public boolean hasNext() {
        return this.values.hasNext();
    }

    public void remove() {
        this.values.remove();
    }

    public SelfDescribing next() {
        return new SelfDescribingValue(this.values.next());
    }
}

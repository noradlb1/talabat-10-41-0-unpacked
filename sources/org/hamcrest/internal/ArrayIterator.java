package org.hamcrest.internal;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.lang.reflect.Array;
import java.util.Iterator;

public class ArrayIterator implements Iterator<Object>, j$.util.Iterator {
    private final Object array;
    private int currentIndex = 0;

    public ArrayIterator(Object obj) {
        if (obj.getClass().isArray()) {
            this.array = obj;
            return;
        }
        throw new IllegalArgumentException("not an array");
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public boolean hasNext() {
        return this.currentIndex < Array.getLength(this.array);
    }

    public Object next() {
        Object obj = this.array;
        int i11 = this.currentIndex;
        this.currentIndex = i11 + 1;
        return Array.get(obj, i11);
    }

    public void remove() {
        throw new UnsupportedOperationException("cannot remove items from an array");
    }
}

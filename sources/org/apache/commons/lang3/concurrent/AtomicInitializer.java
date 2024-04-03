package org.apache.commons.lang3.concurrent;

import i.b;
import java.util.concurrent.atomic.AtomicReference;

public abstract class AtomicInitializer<T> implements ConcurrentInitializer<T> {
    private final AtomicReference<T> reference = new AtomicReference<>();

    public T get() throws ConcurrentException {
        T t11 = this.reference.get();
        if (t11 != null) {
            return t11;
        }
        T initialize = initialize();
        if (!b.a(this.reference, (Object) null, initialize)) {
            return this.reference.get();
        }
        return initialize;
    }

    public abstract T initialize() throws ConcurrentException;
}

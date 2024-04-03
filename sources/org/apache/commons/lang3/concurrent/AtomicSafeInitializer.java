package org.apache.commons.lang3.concurrent;

import i.b;
import java.util.concurrent.atomic.AtomicReference;

public abstract class AtomicSafeInitializer<T> implements ConcurrentInitializer<T> {
    private final AtomicReference<AtomicSafeInitializer<T>> factory = new AtomicReference<>();
    private final AtomicReference<T> reference = new AtomicReference<>();

    public final T get() throws ConcurrentException {
        while (true) {
            T t11 = this.reference.get();
            if (t11 != null) {
                return t11;
            }
            if (b.a(this.factory, (Object) null, this)) {
                this.reference.set(initialize());
            }
        }
    }

    public abstract T initialize() throws ConcurrentException;
}

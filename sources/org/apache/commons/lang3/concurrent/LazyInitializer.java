package org.apache.commons.lang3.concurrent;

public abstract class LazyInitializer<T> implements ConcurrentInitializer<T> {
    private volatile T object;

    public T get() throws ConcurrentException {
        T t11 = this.object;
        if (t11 == null) {
            synchronized (this) {
                t11 = this.object;
                if (t11 == null) {
                    t11 = initialize();
                    this.object = t11;
                }
            }
        }
        return t11;
    }

    public abstract T initialize() throws ConcurrentException;
}

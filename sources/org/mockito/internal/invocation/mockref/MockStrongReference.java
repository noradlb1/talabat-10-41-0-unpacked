package org.mockito.internal.invocation.mockref;

import java.io.ObjectStreamException;

public class MockStrongReference<T> implements MockReference<T> {
    private final boolean deserializeAsWeakRef;
    private final T ref;

    public MockStrongReference(T t11, boolean z11) {
        this.ref = t11;
        this.deserializeAsWeakRef = z11;
    }

    private Object readResolve() throws ObjectStreamException {
        if (this.deserializeAsWeakRef) {
            return new MockWeakReference(this.ref);
        }
        return this;
    }

    public T get() {
        return this.ref;
    }
}

package org.junit.platform.engine.support.hierarchical;

import r30.o;

class NopLock implements ResourceLock {

    /* renamed from: b  reason: collision with root package name */
    public static final ResourceLock f28072b = new NopLock();

    private NopLock() {
    }

    public ResourceLock acquire() {
        return this;
    }

    public /* synthetic */ void close() {
        o.a(this);
    }

    public void release() {
    }
}

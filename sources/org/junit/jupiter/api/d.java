package org.junit.jupiter.api;

import j$.util.function.Supplier;

public final /* synthetic */ class d implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f57145a;

    public /* synthetic */ d(int i11) {
        this.f57145a = i11;
    }

    public final Object get() {
        return String.format("fast-forward(%d) limit must be greater than zero", new Object[]{Integer.valueOf(this.f57145a)});
    }
}

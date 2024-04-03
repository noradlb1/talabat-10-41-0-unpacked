package org.junit.jupiter.engine.discovery;

import j$.util.function.Supplier;

public final /* synthetic */ class b0 implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f62495a;

    public /* synthetic */ b0(String str) {
        this.f62495a = str;
    }

    public final Object get() {
        return String.format("Method [%s] does not match pattern [%s]", new Object[]{this.f62495a, MethodFinder.METHOD_PATTERN});
    }
}

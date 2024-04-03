package org.junit.jupiter.engine.extension;

import j$.util.function.Supplier;
import java.lang.reflect.Method;

public final /* synthetic */ class b implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Method f62587a;

    public /* synthetic */ b(Method method) {
        this.f62587a = method;
    }

    public final Object get() {
        return String.format("Configuration error: @RepeatedTest on method [%s] must be declared with a non-empty name.", new Object[]{this.f62587a});
    }
}

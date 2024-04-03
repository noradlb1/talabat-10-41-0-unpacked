package org.junit.jupiter.api.condition;

import j$.util.function.Supplier;
import java.lang.reflect.Method;

public final /* synthetic */ class t implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Method f57139a;

    public /* synthetic */ t(Method method) {
        this.f57139a = method;
    }

    public final Object get() {
        return String.format("Method [%s] must return a boolean", new Object[]{this.f57139a});
    }
}

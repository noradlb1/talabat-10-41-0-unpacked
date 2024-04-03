package org.junit.jupiter.api.condition;

import j$.util.function.Supplier;
import java.lang.reflect.Method;

public final /* synthetic */ class u implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Method f57140a;

    public /* synthetic */ u(Method method) {
        this.f57140a = method;
    }

    public final Object get() {
        return String.format("Method [%s] must accept either an ExtensionContext or no arguments", new Object[]{this.f57140a});
    }
}

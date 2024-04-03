package org.junit.jupiter.engine.extension;

import j$.util.function.Supplier;
import java.lang.reflect.Method;

public final /* synthetic */ class c implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Method f62588a;

    public /* synthetic */ c(Method method) {
        this.f62588a = method;
    }

    public final Object get() {
        return String.format("Configuration error: @RepeatedTest on method [%s] must be declared with a positive 'value'.", new Object[]{this.f62588a});
    }
}

package org.junit.jupiter.engine.descriptor;

import j$.util.function.Supplier;
import java.lang.reflect.AnnotatedElement;

public final /* synthetic */ class g implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnnotatedElement f62439a;

    public /* synthetic */ g(AnnotatedElement annotatedElement) {
        this.f62439a = annotatedElement;
    }

    public final Object get() {
        return String.format("Configuration error: @DisplayName on [%s] must be declared with a non-empty value.", new Object[]{this.f62439a});
    }
}

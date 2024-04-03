package org.junit.jupiter.engine.discovery;

import j$.util.function.BiFunction;
import j$.util.function.Function;
import j$.util.function.Supplier;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.discovery.IterationSelector;

public final /* synthetic */ class l0 implements BiFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IterationSelector f62517a;

    public /* synthetic */ l0(IterationSelector iterationSelector) {
        this.f62517a = iterationSelector;
    }

    public /* synthetic */ BiFunction andThen(Function function) {
        return BiFunction.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj, Object obj2) {
        return MethodSelectorResolver.lambda$resolve$6(this.f62517a, (TestDescriptor) obj, (Supplier) obj2);
    }
}

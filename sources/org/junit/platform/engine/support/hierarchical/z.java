package org.junit.platform.engine.support.hierarchical;

import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.concurrent.Future;

public final /* synthetic */ class z implements BiFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Future f28107a;

    public /* synthetic */ z(Future future) {
        this.f28107a = future;
    }

    public /* synthetic */ BiFunction andThen(Function function) {
        return BiFunction.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj, Object obj2) {
        return c0.b(this.f28107a);
    }
}

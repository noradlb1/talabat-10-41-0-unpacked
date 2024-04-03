package org.junit.jupiter.engine.descriptor;

import j$.util.function.Function;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.DynamicNode;

public final /* synthetic */ class k implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DynamicContainerTestDescriptor f62452a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AtomicInteger f62453b;

    public /* synthetic */ k(DynamicContainerTestDescriptor dynamicContainerTestDescriptor, AtomicInteger atomicInteger) {
        this.f62452a = dynamicContainerTestDescriptor;
        this.f62453b = atomicInteger;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f62452a.lambda$execute$0(this.f62453b, (DynamicNode) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}

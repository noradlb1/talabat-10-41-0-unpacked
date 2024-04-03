package org.junit.jupiter.engine.discovery;

import j$.util.function.Consumer;
import org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor;

public final /* synthetic */ class f0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MethodOrderingVisitor f62504b;

    public /* synthetic */ f0(MethodOrderingVisitor methodOrderingVisitor) {
        this.f62504b = methodOrderingVisitor;
    }

    public final void accept(Object obj) {
        this.f62504b.lambda$visit$0((ClassBasedTestDescriptor) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}

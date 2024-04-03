package org.junit.jupiter.engine.discovery;

import j$.util.function.Consumer;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor;

public final /* synthetic */ class e0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MethodOrderingVisitor f62499b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Class f62500c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ClassBasedTestDescriptor f62501d;

    public /* synthetic */ e0(MethodOrderingVisitor methodOrderingVisitor, Class cls, ClassBasedTestDescriptor classBasedTestDescriptor) {
        this.f62499b = methodOrderingVisitor;
        this.f62500c = cls;
        this.f62501d = classBasedTestDescriptor;
    }

    public final void accept(Object obj) {
        this.f62499b.lambda$orderContainedMethods$6(this.f62500c, this.f62501d, (MethodOrderer) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}

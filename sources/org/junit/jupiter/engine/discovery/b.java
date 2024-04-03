package org.junit.jupiter.engine.discovery;

import j$.util.function.Predicate;
import org.junit.platform.engine.TestDescriptor;

public final /* synthetic */ class b implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Class f62494a;

    public /* synthetic */ b(Class cls) {
        this.f62494a = cls;
    }

    public /* synthetic */ Predicate and(Predicate predicate) {
        return Predicate.CC.$default$and(this, predicate);
    }

    public /* synthetic */ Predicate negate() {
        return Predicate.CC.$default$negate(this);
    }

    public /* synthetic */ Predicate or(Predicate predicate) {
        return Predicate.CC.$default$or(this, predicate);
    }

    public final boolean test(Object obj) {
        return AbstractOrderingVisitor.lambda$orderChildrenTestDescriptors$1(this.f62494a, (TestDescriptor) obj);
    }
}

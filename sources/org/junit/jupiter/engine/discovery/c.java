package org.junit.jupiter.engine.discovery;

import j$.util.function.Predicate;
import java.util.Set;

public final /* synthetic */ class c implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Set f62496a;

    public /* synthetic */ c(Set set) {
        this.f62496a = set;
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
        return this.f62496a.contains((AbstractAnnotatedDescriptorWrapper) obj);
    }
}

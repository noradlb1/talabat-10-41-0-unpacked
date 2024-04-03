package org.mockito.internal.creation.bytebuddy;

import j$.util.function.Predicate;

public final /* synthetic */ class a implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TypeSupport f63172a;

    public /* synthetic */ a(TypeSupport typeSupport) {
        this.f63172a = typeSupport;
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
        return this.f63172a.a((Class) obj);
    }
}

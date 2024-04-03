package org.junit.platform.engine.discovery;

import j$.util.function.Predicate;

public final /* synthetic */ class m implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f28043a;

    public /* synthetic */ m(String str) {
        this.f28043a = str;
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
        return IncludePackageNameFilter.lambda$findMatchingName$3(this.f28043a, (String) obj);
    }
}

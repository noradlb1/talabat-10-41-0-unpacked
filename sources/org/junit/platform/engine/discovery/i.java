package org.junit.platform.engine.discovery;

import j$.util.function.Predicate;

public final /* synthetic */ class i implements Predicate {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f28037a;

    public /* synthetic */ i(String str) {
        this.f28037a = str;
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
        return ExcludePackageNameFilter.lambda$findMatchingName$3(this.f28037a, (String) obj);
    }
}

package org.junit.jupiter.api.condition;

import j$.util.function.Supplier;

public final /* synthetic */ class s implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodBasedCondition f57138a;

    public /* synthetic */ s(MethodBasedCondition methodBasedCondition) {
        this.f57138a = methodBasedCondition;
    }

    public final Object get() {
        return this.f57138a.enabledByDefault();
    }
}

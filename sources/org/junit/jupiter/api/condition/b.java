package org.junit.jupiter.api.condition;

import j$.util.function.Supplier;

public final /* synthetic */ class b implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AbstractOsBasedExecutionCondition f57114a;

    public /* synthetic */ b(AbstractOsBasedExecutionCondition abstractOsBasedExecutionCondition) {
        this.f57114a = abstractOsBasedExecutionCondition;
    }

    public final Object get() {
        return this.f57114a.enabledByDefault();
    }
}

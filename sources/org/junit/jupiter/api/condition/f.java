package org.junit.jupiter.api.condition;

import j$.util.function.Supplier;

public final /* synthetic */ class f implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BooleanExecutionCondition f57121a;

    public /* synthetic */ f(BooleanExecutionCondition booleanExecutionCondition) {
        this.f57121a = booleanExecutionCondition;
    }

    public final Object get() {
        return this.f57121a.enabledByDefault();
    }
}

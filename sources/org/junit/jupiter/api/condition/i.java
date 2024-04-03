package org.junit.jupiter.api.condition;

import j$.util.function.Supplier;

public final /* synthetic */ class i implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DisabledIfSystemProperty f57124a;

    public /* synthetic */ i(DisabledIfSystemProperty disabledIfSystemProperty) {
        this.f57124a = disabledIfSystemProperty;
    }

    public final Object get() {
        return DisabledIfSystemPropertyCondition.lambda$evaluate$0(this.f57124a);
    }
}

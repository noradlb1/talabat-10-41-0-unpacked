package org.junit.jupiter.api.condition;

import j$.util.function.Supplier;

public final /* synthetic */ class m implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EnabledIfSystemProperty f57128a;

    public /* synthetic */ m(EnabledIfSystemProperty enabledIfSystemProperty) {
        this.f57128a = enabledIfSystemProperty;
    }

    public final Object get() {
        return EnabledIfSystemPropertyCondition.lambda$evaluate$0(this.f57128a);
    }
}

package org.junit.jupiter.api.condition;

import j$.util.function.Supplier;

public final /* synthetic */ class n implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EnabledIfSystemProperty f57129a;

    public /* synthetic */ n(EnabledIfSystemProperty enabledIfSystemProperty) {
        this.f57129a = enabledIfSystemProperty;
    }

    public final Object get() {
        return EnabledIfSystemPropertyCondition.lambda$evaluate$1(this.f57129a);
    }
}

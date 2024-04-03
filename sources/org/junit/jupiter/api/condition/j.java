package org.junit.jupiter.api.condition;

import j$.util.function.Supplier;

public final /* synthetic */ class j implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DisabledIfSystemProperty f57125a;

    public /* synthetic */ j(DisabledIfSystemProperty disabledIfSystemProperty) {
        this.f57125a = disabledIfSystemProperty;
    }

    public final Object get() {
        return DisabledIfSystemPropertyCondition.lambda$evaluate$1(this.f57125a);
    }
}

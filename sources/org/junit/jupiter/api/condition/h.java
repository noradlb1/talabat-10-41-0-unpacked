package org.junit.jupiter.api.condition;

import j$.util.function.Supplier;

public final /* synthetic */ class h implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DisabledIfEnvironmentVariable f57123a;

    public /* synthetic */ h(DisabledIfEnvironmentVariable disabledIfEnvironmentVariable) {
        this.f57123a = disabledIfEnvironmentVariable;
    }

    public final Object get() {
        return DisabledIfEnvironmentVariableCondition.lambda$evaluate$1(this.f57123a);
    }
}

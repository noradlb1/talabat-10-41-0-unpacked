package org.junit.jupiter.api.condition;

import j$.util.function.Supplier;

public final /* synthetic */ class g implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DisabledIfEnvironmentVariable f57122a;

    public /* synthetic */ g(DisabledIfEnvironmentVariable disabledIfEnvironmentVariable) {
        this.f57122a = disabledIfEnvironmentVariable;
    }

    public final Object get() {
        return DisabledIfEnvironmentVariableCondition.lambda$evaluate$0(this.f57122a);
    }
}

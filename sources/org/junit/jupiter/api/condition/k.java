package org.junit.jupiter.api.condition;

import j$.util.function.Supplier;

public final /* synthetic */ class k implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EnabledIfEnvironmentVariable f57126a;

    public /* synthetic */ k(EnabledIfEnvironmentVariable enabledIfEnvironmentVariable) {
        this.f57126a = enabledIfEnvironmentVariable;
    }

    public final Object get() {
        return EnabledIfEnvironmentVariableCondition.lambda$evaluate$0(this.f57126a);
    }
}

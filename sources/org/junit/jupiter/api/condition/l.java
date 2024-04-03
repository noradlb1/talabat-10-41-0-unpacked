package org.junit.jupiter.api.condition;

import j$.util.function.Supplier;

public final /* synthetic */ class l implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EnabledIfEnvironmentVariable f57127a;

    public /* synthetic */ l(EnabledIfEnvironmentVariable enabledIfEnvironmentVariable) {
        this.f57127a = enabledIfEnvironmentVariable;
    }

    public final Object get() {
        return EnabledIfEnvironmentVariableCondition.lambda$evaluate$1(this.f57127a);
    }
}

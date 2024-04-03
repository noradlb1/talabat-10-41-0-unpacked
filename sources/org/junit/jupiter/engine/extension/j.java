package org.junit.jupiter.engine.extension;

import j$.util.function.Supplier;
import org.junit.jupiter.api.extension.ParameterContext;

public final /* synthetic */ class j implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ParameterContext f62603a;

    public /* synthetic */ j(ParameterContext parameterContext) {
        this.f62603a = parameterContext;
    }

    public final Object get() {
        return TempDirectory.lambda$determineCleanupModeForParameter$3(this.f62603a);
    }
}

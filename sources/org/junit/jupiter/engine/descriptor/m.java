package org.junit.jupiter.engine.descriptor;

import org.junit.jupiter.api.extension.InvocationInterceptor;
import z20.f;

public final /* synthetic */ class m implements InvocationInterceptor.Invocation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DynamicTestTestDescriptor f62458a;

    public /* synthetic */ m(DynamicTestTestDescriptor dynamicTestTestDescriptor) {
        this.f62458a = dynamicTestTestDescriptor;
    }

    public final Object proceed() {
        return this.f62458a.lambda$execute$0();
    }

    public /* synthetic */ void skip() {
        f.a(this);
    }
}
